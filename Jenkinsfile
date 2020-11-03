pipeline {
    agent {
    kubernetes {
      label 'promo-app'  // all your pods will be named with this prefix, followed by a unique id
      idleMinutes 5  // how long the pod will live after no jobs have run on it
      yamlFile 'pods.yaml'  // path to the pod definition relative to the root of our project
      yamlFile 'service.yaml' 
    }
  }
    
    tools {
      maven "M2_HOME"
      jdk "JDK"
   }

    stages {
        
        stage('checkout'){
              steps {
         git 'https://github.com/vishnuishpujani/JenkinsSample.git'      
        }
              }
      stage('Build Project') {
         steps {
            // Get some code from a GitHub repository 
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'
            bat "mvn clean compile"
         }
         }
      stage("Test") {
          steps {
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            bat "mvn clean test"
            
          }

      }
      stage("Deploy") {
          steps {
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            bat "mvn clean install"
            
          }
        }  
        
          stage("build & SonarQube analysis") {
            steps {
              withSonarQubeEnv('sonarQube') {
                bat "mvn clean package sonar:sonar"
              }
            }
          }
        
        stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        
        stage('Docker Build') {
      agent any
      steps {
        bat 'docker build -t vishnu95/test:latest .'
      }
    }
    stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'Dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          bat "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          bat 'docker push vishnu95/test:latest'
        }
      }
    }
    
//    stage("Deploy to kubernetes"){
//        steps{
  //  bat "kubectl create -f pods.yml"
  //  bat "kubectl create -f service.yaml"
   //	}
   // }
          
          }
          post {
              success {
                  step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/TEST-*.xml'])
                  archiveArtifacts 'target/*.jar'
              }

          }


      }


