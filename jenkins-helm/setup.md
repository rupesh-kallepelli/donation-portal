# Jenkins Setup on OpenShift (OCP) Free Trial using Helm

## 🧰 Prerequisites

- OpenShift free trial cluster
- `oc` CLI installed and configured
- `helm` CLI installed
- Jenkins Helm chart (from OpenShift's helm repo or custom)
- GitHub personal access token (PAT) if integrating with GitHub

---

## 🚀 Steps

### 1. Connect to Your OCP Cluster

Use the login token (replace with your own):

```bash
oc login --token=<your-token> --server=https://<cluster-api>


If token is expired, re-authenticate via OCP web console and generate a new token.

2. Create a Namespace
oc new-project kallepelli-rupesh-dev

3. Deploy Jenkins using Helm

Place your Jenkins Helm chart into a folder, e.g., jenkins-helm, and install:

helm install jenkins ./jenkins-helm -n kallepelli-rupesh-dev


If you encounter this error:

INSTALLATION FAILED: must either provide a name or specify --generate-name


Fix with:

helm install jenkins ./jenkins-helm -n kallepelli-rupesh-dev

4. Verify Jenkins Deployment
oc get pods -n kallepelli-rupesh-dev
oc get svc -n kallepelli-rupesh-dev


Expose the service via a route if not already:

oc expose svc jenkins -n kallepelli-rupesh-dev


Get the route:

oc get route jenkins -n kallepelli-rupesh-dev

5. Access Jenkins

Open the URL shown from the oc get route output.

Since OpenShift Jenkins chart uses OpenShift OAuth, login will be via your OpenShift account.

6. Create a GitHub Credential

Go to:

Credentials → System → Global Credentials (unrestricted)

Add a new credential:

Kind: Secret text

Secret: GitHub PAT

ID: github-token (you’ll use this in pipelines)

7. Add Cluster Connection to Jenkins

In Jenkins:

Go to Manage Jenkins → Configure System

Add Kubernetes cloud under Cloud

Use:

Kubernetes URL: https://kubernetes.default.svc

Kubernetes Namespace: kallepelli-rupesh-dev

Credentials: Create a ServiceAccount and token manually or via:

oc create sa jenkins-agent -n kallepelli-rupesh-dev
oc adm policy add-cluster-role-to-user edit system:serviceaccount:kallepelli-rupesh-dev:jenkins-agent


Generate token (OpenShift 4.x+):

oc create token jenkins-agent -n kallepelli-rupesh-dev


Use this token in Jenkins Kubernetes cloud credentials.

8. Fix JNLP Connectivity

Your agent was failing with:

UnresolvedAddressException for jenkins-jnlp


Because the service name is actually jenkins, not jenkins-jnlp.

Fix:
Update Jenkins Kubernetes plugin settings:

Jenkins tunnel: jenkins:50000

Or fully qualified: jenkins.kallepelli-rupesh-dev.svc.cluster.local:50000

9. Pod Template Setup

In Kubernetes Cloud config, add a Pod Template:

Name: jnlp-agent

Container:

Name: jnlp

Image: jenkins/inbound-agent

WorkingDir: /home/jenkins/agent

Set args to ${computer.jnlpmac} ${computer.name}

10. Use Agent in Jenkinsfile
pipeline {
  agent {
    kubernetes {
      label 'jnlp-agent'
      defaultContainer 'jnlp'
    }
  }
  environment {
    GITHUB_TOKEN = credentials('github-token')
  }
  stages {
    stage('Test') {
      steps {
        sh 'echo Hello from Jenkins agent on OpenShift'
        sh 'curl -H "Authorization: token $GITHUB_TOKEN" https://api.github.com/user'
      }
    }
  }
}

✅ Done!

You now have:

Jenkins running in OpenShift via Helm

OAuth login enabled

GitHub PAT stored as credential

Kubernetes agents working via JNLP

Jenkinsfile configured for dynamic agent

🧩 Troubleshooting Tips

JNLP Port Unreachable: Ensure the correct jenkins:50000 service is used.

Pod Fails to Connect: Check Pod Template → Jenkins URL and Tunnel.

Token Issues: Use oc create token not deprecated oc serviceaccounts get-token.