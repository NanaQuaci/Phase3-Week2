pipeline {
    agent{
        label 'docker'
    }

    tools {
        allure 'Allure_Report'
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout Code') {
            steps {
               checkout scm
            }
        }


        stage('Build Docker Image') {
            steps {
                sh 'docker build -t restassured_api_tests .'
            }
        }

            stage('Run Tests in Docker') {
                steps {
                    sh '''
                        mkdir -p allure-results target/surefire-reports
                        chmod 777 allure-results target/surefire-reports
                        docker run --rm \
                            --user $(id -u):$(id -g) \
                            -v "$PWD/allure-results:/app/allure-results:rw" \
                            -v "$PWD/target/surefire-reports:/app/target/surefire-reports:rw" \
                            restassured_api_tests
                    '''
                }
            }



        stage('Publish Allure Report in Jenkins') {
            when {
                expression { fileExists('allure-results') }
            }
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }

    post {
        always {
            echo 'Archiving tests results and Allure report...'

            // Archive Allure report files
            archiveArtifacts artifacts: 'allure-report/**', allowEmptyArchive: true

            // Publish JUnit XML result
            junit '**/target/surefire-reports/*.xml'

            //Send Slack notification
            script {
                try {
                    //Determine status emoji and text
                    def statusEmoji = ""
                    def statusText = ""

                    if (currentBuild.result == 'SUCCESS') {
                        statusEmoji = ":white_check_mark:"
                        statusText = "success"
                    } else if (currentBuild.result == 'UNSTABLE') {
                        statusEmoji = ":warning:"
                        statusText = "unstable"
                    } else {
                        statusEmoji = ":x:"
                        statusText = "failed"
                    }

                    // Get commit hash (first 8 characters)
                    def commitHash = env.GIT_COMMIT ? env.GIT_COMMIT.take(8) : "unknown"

                    // Build the message
                    def message = "${statusEmoji} REST Assured API Tests finished with status: ${statusText} " +
                                 ":package: Repo: ${env.JOB_NAME} " +
                                 ":link: Commit: ${commitHash} " +
                                 ":bar_chart: Report: ${env.BUILD_URL}allure"
                    slackSend(
                        channel: '#ci-alerts',
                        color: currentBuild.result == 'SUCCESS' ? 'good' : 'danger',
                        message: "REST Assured Docker Tests: *${currentBuild.result}* - ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|View Build>)"
                    )
                } catch (err) {
                    echo "Slack notification failed: ${err}"
                }
            }
        }
    }
}
