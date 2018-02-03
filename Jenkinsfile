pipeline {
    agent any
    tools { 
        maven 'mvn' 
        jdk 'Java 8' 
    }
    stages {
        //Echos environment variables.
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            //Runs shell command invoking Maven.
            steps {
                sh 'mvn -B -f /var/lib/jenkins/workspace/Test_test_test_master-G7PLR452U2TRLXAWXHW3XUJ7LDU4F6JZIGNLKR7UDME4OHC4KZVQ//discussion-service/pom.xml clean verify'
            }    
        }
        stage ('Deployment') {
            //Sends completed API to EC2 instance for Docker-ization.
            steps {
                dir 'discussion-service/target'
                sshagent (credentials: ['jenkins (EC2)']) {
                    sh 'scp discussion-service-0.0.1-SNAPSHOT.jar ec2-user@ec2-54-165-246-73.compute-1.amazonaws.com:/home/'
                   }
             }     
}
}
