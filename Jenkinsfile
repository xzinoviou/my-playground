pipeline {
    agent any

    environment {
        DB_SCHEMA=credentials('DB_SCHEMA')
        FLYWAY_USER=credentials('FLYWAY_USER')
        FLYWAY_PASSWORD=credentials('FLYWAY_PASSWORD')
        FLYWAY_TEST_USER=credentials('FLYWAY_TEST_USER')
        FLYWAY_TEST_PASSWORD=credentials('FLYWAY_TEST_PASSWORD')
        H2_TEST_DB=credentials('H2_TEST_DB')
        H2_TEST_USER=credentials('H2_TEST_USER')
        H2_TEST_PASSWORD=credentials('H2_TEST_PASSWORD')
        MYSQL_DB=credentials('MYSQL_DB')
        MYSQL_HOST=credentials('MYSQL_HOST')
        MYSQL_PORT=credentials('MYSQL_PORT')
        MYSQL_URL=credentials('MYSQL_URL')
        MYSQL_USER=credentials('MYSQL_USER')
        MYSQL_PASSWORD=credentials('MYSQL_PASSWORD')
    }

    stages {

        stage("build") {
            steps {
                echo "[----- ENV VARS -----]"
                sh 'env | sort'
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
