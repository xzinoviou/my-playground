pipeline {
    agent any

    stages {

        stage("build") {
            steps {
                echo "[----- Build Start -----]"
                sh './mvnw -DskipTests clean package'
            }
        }

        stage("test") {
            steps {
                echo "[----- Tests Start -----]"
                sh './mvnw test'
            }
        }

        stage("integration-test") {
            steps {
                echo "[----- Integration Tests Start -----]"
                sh './mvnw verify -Dskip.surefire.tests'
            }
        }

      stage("groovy-check") {
                steps {
                    echo "[----- Groovy check -----]"
                    script {
                        def result = 10 > 1 ? 'Groovy Checked' : 'Groovy unchecked'
                        echo "[----- $result -----]"
                    }
                }
        }
    }
}
