pipeline {
    agent {
        kubernetes {
            label 'inline-agent'
            defaultContainer 'jnlp'
            yamlFile "jenkins-agent.yaml"
        }
    }
    stages {
        stage('Hello') {
            steps {
                dir(env.WORKSPACE) {
                    container('java') {
                        script {
                            echo "Hello from a Kubernetes pod!"
                            sh 'whoami'
                            sh 'printenv'
                            sh './donation-backend/api-gateway/mvnw clean install -DskipTests'
                        }
                    }
                }
            }
        }
    }
}
