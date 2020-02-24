pipeline {
    agent any

	tools {
        maven 'maven-local'
    }

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
                    sh 'mvn deploy -DskipTests'
                }
        }
        
        /*
        stage ('Release Prepare Stage') {
            steps {
                    sh 'mvn release:prepare -DskipTests'
                }
        }
        */
        
        /*
        stage ('Release perform Stage') {
            steps {
                    sh 'mvn release:perform -Darguments="-Dmaven.javadoc.skip=true" -DskipTests'
                }
        }
        */
        
    }
}