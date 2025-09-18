pipeline {
    agent {
        kubernetes {
            label 'inline-agent'
            defaultContainer 'jnlp'
            yaml "jenkins-agent.yaml"
        }
    }
    stages {
        stage('Hello') {
            dir(env.WORKSPACE) {
                container('java') {
                    steps {
                        echo "Hello from a Kubernetes pod!"
                        sh 'whoami'
                        sh 'java -version'
                        sh './donation-backend/api-gateway/mvw clean install -DskipTests'
                    }
                }
            }
        }
    }
}
