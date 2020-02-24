pipeline {
    agent any

    stages {
    
    	/*
    	stage ('SonarQube Stage') {
            steps {
            		sh 'mvn clean install verify'
                    sh 'mvn sonar:sonar'
                }
        }
        */
    
        stage ('Compile Stage') {
            steps {
                    sh 'mvn clean compile'
                }
        }

        stage ('Testing Stage') {
            steps {
                    sh 'mvn test'
                }
        }
        
        /*
        stage ('Deploy Stage') {
            steps {
                    sh 'mvn deploy'
                }
        }
        
        /*
        stage ('Release Prepare Stage') {
            steps {
                    sh 'mvn release:prepare'
                }
        }
        */
        
        /*
        stage ('Release perform Stage') {
            steps {
                    sh 'mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"'
                }
        }
        */
        
    }
}