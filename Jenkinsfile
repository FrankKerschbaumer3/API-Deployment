pipeline {
    agent any
    tools { 
        maven 'mvn' 
        jdk 'Java 8' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                sh 'pwd'
                sh 'ls'
                sh 'ls /discussion-service/
            }
        }
    }
}
        
