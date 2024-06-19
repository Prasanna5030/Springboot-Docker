pipeline{
    agent any
    
    tools{
        maven 'MAVEN'
    }

    stages{
        stage('git checkout'){
            steps{
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Prasanna5030/Springboot-Docker']]) 
            }
        }
        
        stage('maven build'){
            steps{
                bat 'mvn clean install'
            }
        }
        
        stage('build docker image'){
            steps{
                script{
                    bat 'docker build -t prasanna5030/springboot-docker .'
                }
            }
        }
        
        stage('push image to dockerhub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'pwd-docker', variable: 'pwd-docker')]) {
                   bat 'docker login -u prasanna5030 -p ${pwd-docker}'    
}
                    bat 'docker push prasanna5030/springboot-docker'
                }
            }
        }
        
        stage('run the container'){
            steps{
                script{
                    bat 'docker-compose -f docker-compose.yml up'
                }
            }
        }
    }
}
