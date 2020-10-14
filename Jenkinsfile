pipeline {
    agent any
    
    tools {
      maven "M2_HOME"
   }

    stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository 
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'
            sh "mvn clean compile"
         }
         }
      stage("Test") {
          steps {
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            sh "mvn clean test"
            
          }

      }
      stage("Deploy") {
          steps {
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            sh "mvn clean install"
            
          }
          post {
              success {
                  archiveArtifacts 'target/*.jar'
              }

          }


      }

      }
   }
