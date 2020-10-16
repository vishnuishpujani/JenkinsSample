pipeline {
    agent any
    
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
          
         pipeline {
        agent none
        stages {
          stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('sonarQube') {
                sh 'mvn clean package sonar:sonar'
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
        }
      }
      }
          post {
              success {
                  step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/TEST-*.xml'])
                  archiveArtifacts 'target/*.jar'
              }

          }


      }

      }
   }
