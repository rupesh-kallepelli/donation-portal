#!/bin/bash groovy

pipeline {
    agent {
        kubernetes {
            label 'jenkins-agent'
            defaultContainer 'jnlp'
            yamlFile "jenkins-agent.yaml"
        }
    }
    environment {
       OC_SERVER="https://api.rm1.0a51.p1.openshiftapps.com:6443"
    }
    stages {
        stage('local-install') {
            steps {
                dir(env.WORKSPACE) {
                    dir('donation-backend') {
                        dir('api-gateway') {
                            container('java') {
                                script {
                                    configFileProvider([configFile(fileId: 'mvn_settings', variable: 'MVN_SETTINGS')]) {
                                        sh "chmod +x ${pwd()}/mvnw"
                                        sh "${pwd()}/mvnw clean install -s $MVN_SETTINGS -DskipTests"
                                        sh 'cp target/*.jar /mnt/artifacts/'
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        stage('build-image') {
            steps {
                dir(env.WORKSPACE) {
                    dir('donation-backend') {
                        dir('api-gateway') {
                            container('oc-tools') {
                                script {
                                    withCredentials([string(credentialsId: 'ocp-token', variable: 'OC_TOKEN')]) {
                                        sh 'oc login --token=$OC_TOKEN --server=$OC_SERVER --insecure-skip-tls-verify=true'
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
