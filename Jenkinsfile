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
       stage ('Build') {
           steps { 
           withMaven(
            // Maven installation declared in the Jenkins "Global Tool Configuration"
            maven: 'mvn',
            // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
            // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
            mavenSettingsConfig: 'my-maven-settings',
            mavenLocalRepo: '.repository') {
 
            // Run the maven build
            sh "mvn clean verify"
          }
       }              
}
}
}
