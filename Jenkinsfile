pipeline {
    agent {
        kubernetes {
            label 'inline-agent'
            defaultContainer 'jnlp'
            yaml """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: jnlp
    image: jenkins/inbound-agent:latest
    tty: true
    volumeMounts:
    - name: workspace-volume
      mountPath: /home/jenkins/agent
  volumes:
  - name: workspace-volume
    emptyDir: {}
"""
        }
    }
    stages {
        stage('Hello') {
            steps {
                echo "Hello from a Kubernetes pod!"
                sh 'whoami'
            }
        }
    }
}
