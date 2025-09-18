pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                sh 'kubectl get pods'
            }
        }
        stage('Test'){
            steps{
                echo 'Testing...'
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploying...'
            }
        }
    }
}
