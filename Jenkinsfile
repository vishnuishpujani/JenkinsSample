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
            sh "mvn -Dmaven.test.failure.ignore=true clean compile"
         }
         }
      stage("Test") {
          steps {
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            sh "mvn -Dmaven.test.failure.ignore=true clean test"
            
          }

      }
      stage("Deploy") {
          steps {
            //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            sh "mvn -Dmaven.test.failure.ignore=true clean install"
            
          }
          post {
              success {
                  archiveArtifacts 'target/*.jar'
              }

          }


      }

      }
   }
