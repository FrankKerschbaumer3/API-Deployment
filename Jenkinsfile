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
            //Sends completed API to EC2 instance.
            steps {
                sshagent(['36f0d33e-890f-4cb0-8dec-0f684bdfecd9']) {
                    sh 'scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/Test_test_test_master-G7PLR452U2TRLXAWXHW3XUJ7LDU4F6JZIGNLKR7UDME4OHC4KZVQ/discussion-service/target/discussion-service-0.0.1-SNAPSHOT.jar ec2-user@ec2-52-91-85-223.compute-1.amazonaws.com:/home/ec2-user/api'                      
                } 
            }
        }
         
         stage ('Dockerization') {
             //sends command to dockerize
             steps { 
                sshagent(['36f0d33e-890f-4cb0-8dec-0f684bdfecd9']) {
                    sh 'ssh -o StrictHostKeyChecking=no ec2-user@ec2-52-91-85-223.compute-1.amazonaws.com 'bash -s' < /home/ec2-user/script.sh'                                          
                }
            }
                 
        }
}
}
