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
                                    configFileProvider([configFile(fileId: 'mvn_settings', variable: 'MVN_SETTINGS')]) {
                                        sh "chmod +x ${pwd()}/mvnw"
                                        sh "${pwd()}/mvnw clean install -s MVN_SETTINGS \
                                                -DskipTests"
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
