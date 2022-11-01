pipeline {

    agent any
      tools {
        maven '3.8.5'
      }

    parameters {
        string(name: 'VERSION', defaultValue: '1.0.0', description: 'Build Version')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building version ${parameters.VERSION}'
                sh 'mvn  -e -f SpringAngular/pom.xml clean install'

            }
        }
        stage('Test') {
            steps {
                echo 'Testing version ${parameters.VERSION}'
                //sh './mvn test'
            }
            //post {
            //    always {
            //        junit "build/reports/tests/**/*.xml"
            //    }
            //    sh 'mvn clean package'
            //}
        }
    }
}