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
        
        stage("Deploy"){
            steps{
                bat label : '', script: '''rm -rf dockerimg
                FROM openjdk:8
                EXPOSE 8080
                ADD target/docker-my-app-1.0-SNAPSHOT.jar docker-my-app-1.0-SNAPSHOT.jar
                ENTRYPOINT ["java","-jar","/my-app-1.0-SNAPSHOT"]
        }}
          
          }
          post {
              success {
                  step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/TEST-*.xml'])
                  archiveArtifacts 'target/*.jar'
              }

          }


      }


