#!/bin/bash groovy

pipeline {
    agent {
        kubernetes {
            label 'jenkins-agent'
            defaultContainer 'jnlp'
            yamlFile "jenkins-agent.yaml"
        }
    }
    parameters {
        choice(name: 'APP_NAME', choices: ['api-gateway', 'user-service', 'persistence'], description: 'Select the application to build and deploy')
    }
    environment {
       OC_SERVER="https://api.rm1.0a51.p1.openshiftapps.com:6443"
       NAME_SPACE="kallepelli-rupesh-dev"
       REGISTRY_URL="image-registry.openshift-image-registry.svc:5000"
       APP_NAME="${params.APP_NAME}"
    }
    stages {
        stage('build-model') {
            steps {
                dir(env.WORKSPACE) {
                    dir('donation-backend') {
                        dir('model-client') {
                            container('java') {
                                script {
                                    configFileProvider([configFile(fileId: 'mvn_settings', variable: 'MVN_SETTINGS')]) {
                                        sh "chmod +x ${pwd()}/mvnw"
                                        sh "${pwd()}/mvnw clean install -B -s $MVN_SETTINGS \
                                        -DappVersion=${env.BUILD_ID} \
                                        -DappName=${env.APP_NAME} \
                                        -DregistryUrl=${env.REGISTRY_URL} \
                                        -Dnamespace=${env.NAME_SPACE}"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        stage('build-app') {
            steps {
                dir(env.WORKSPACE) {
                    dir('donation-backend') {
                        dir(env.APP_NAME) {
                            container('java') {
                                script {
                                    configFileProvider([configFile(fileId: 'mvn_settings', variable: 'MVN_SETTINGS')]) {
                                        sh "chmod +x ${pwd()}/mvnw"
                                        sh "${pwd()}/mvnw clean install -B -s $MVN_SETTINGS \
                                        -DappVersion=${env.BUILD_ID} \
                                        -DappName=${env.APP_NAME} \
                                        -DregistryUrl=${env.REGISTRY_URL} \
                                        -Dnamespace=${env.NAME_SPACE}"
                                        sh "mkdir -p /mnt/artifacts/tmp-context"
                                        sh "cp target/*.jar /mnt/artifacts/tmp-context/app.jar"
                                        sh "cp build/build-template/Dockerfile /mnt/artifacts/tmp-context/"
                                        sh "ls -al /mnt/artifacts/tmp-context"
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
                        dir(env.APP_NAME) {
                            container('oc-tools') {
                                script {
                                   ocLogin('ocp-token', env.OC_SERVER, env.NAME_SPACE)
                                   try{
                                        sh "oc create -f build/build-template/image-stream.yaml -n ${NAME_SPACE}"
                                   } catch(err){
                                        echo "Image stream already exists"
                                   }
                                   try{
                                        sh "oc create -f build/build-template/image-build.yaml -n ${NAME_SPACE}"
                                   } catch(err){
                                        echo "Build config already exists"
                                         sh "oc replace -f build/build-template/image-build.yaml -n ${NAME_SPACE}"
                                    }finally{
                                        echo "Proceeding to build image"
                                        sh "oc start-build ${env.APP_NAME}-build --from-dir=/mnt/artifacts/tmp-context -n ${NAME_SPACE} --follow"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                dir(env.WORKSPACE) {
                    dir('donation-backend') {
                        dir(env.APP_NAME) {
                            container('oc-tools') {
                                script {
                                   ocLogin('ocp-token', env.OC_SERVER, env.NAME_SPACE)
                                   sh "helm lint ./build "
                                   sh "helm upgrade --install ${env.APP_NAME} ./build "
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
def ocLogin(String credentialsId, String ocServer, String namespace) {
    withCredentials([string(credentialsId: credentialsId, variable: 'OC_TOKEN')]) {
        sh """
            oc login --token=\$OC_TOKEN --server=${ocServer} --insecure-skip-tls-verify=true && \
            oc project ${namespace}
        """
    }
}
