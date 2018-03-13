pipeline {
    agent {
        docker {
            image 'openjdk:8-jdk-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    tools { maven 'M3'}
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -f /discussion-service/pom.xml clean verify'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                 }
              }
          }
      }
   }
}
