pipeline {
    agent any

    stages {

        stage("build") {
            steps {
                echo "[----- Build Start -----]"
                sh './mvnw clean package -Dmaven.test.skip'
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

    post {
       always {
       echo '[--- Pipeline Terminated : Awaiting for results ---]'
       }
       success {
       echo '[--- Pipeline Termination Results : SUCCESSFUL! ---]'
       }
       failure {
       echo '[--- Pipeline Failing Results : FAILED... ---]'
       }
       unstable {
       echo '[--- Pipeline Failing Results : UNSTABLE... ---]'
       }
       changed {
       echo '[--- Pipeline Termination Results : CHANGED... ---]'
       }
    }
}
