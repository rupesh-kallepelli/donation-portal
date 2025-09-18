#!/bin/bash groovy

pipeline {
    agent {
        kubernetes {
            label 'jenkins-agent'
            defaultContainer 'jnlp'
            yamlFile "jenkins-agent.yaml"
        }
    }
    stages {
        stage('Hello') {
            steps {
                dir(env.WORKSPACE) {
                    dir('donation-backend') {
                        dir('api-gateway') {
                            container('java') {
                                script {
                                    echo "Hello from a Kubernetes pod!"
                                    sh 'whoami'
                                    sh 'printenv'
                                    sh 'ls -lrt'
                                    sh "chmod +x ${pwd()}/mvnw"
                                    sh '${pwd()}/mvnw clean install -DskipTests'
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
