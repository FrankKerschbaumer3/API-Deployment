pipeline {
    agent any
    tools { 
        maven 'mvn' 
        jdk 'Java 8' 
    }
    stages {
        //Echos environment variables
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        
        stage ('test') {
            node ('Node') {
            steps {
                sh '''
                    mvn -B -f /var/lib/jenkins/workspace/Test_test_test_master-G7PLR452U2TRLXAWXHW3XUJ7LDU4F6JZIGNLKR7UDME4OHC4KZVQ//discussion-service/pom.xml clean verify'
                '''
            }
        }
    }
}
}  
