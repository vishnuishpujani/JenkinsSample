pipeline {
    agent any
    
    tools {
        //jdk "JDK"
      maven "M2_HOME"
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
            sh "mvn clean compile"
         }
         }
      //stage("Test") {
      //    steps {
       //     //git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
       //     bat "mvn clean test"
            
       //   }

      //}
      stage("Deploy") {
          steps {
            git 'https://github.com/vishnuishpujani/JenkinsSample.git'  
            sh "mvn clean install"
            
          }
        }  
        
       //   stage("build & SonarQube analysis") {
         //   steps {
          //    withSonarQubeEnv('sonarQube') {
           //     sh "mvn clean package sonar:sonar"
           //   }
           // }
         // }
        
       // stage("Quality Gate") {
        //    steps {
         //     timeout(time: 1, unit: 'HOURS') {
          //      waitForQualityGate abortPipeline: true
          //    }
          //  }
         // }
        
        //stage('Docker Build') {
      //agent any
      //steps {
        //sh 'docker build -t vishnu95/test:latest . '
     // }
   // }
    //stage('Docker Push') {
     // agent any
     // steps {
      //  withCredentials([usernamePassword(credentialsId: 'Dockerhub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
       //   sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
       //   sh 'docker push vishnu95/test:latest'
        //}
     // }
   // }
        
        
    stage("Deploy to kubernetes"){
        steps{
            kubernetesDeploy(kubeconfigId: 'kube',            

                 configs: '*.yaml')
    
//    bat "kubectl create -f pods.yaml"
  //  bat "kubectl create -f service.yaml"
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


