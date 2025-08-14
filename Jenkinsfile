pipeline {
    agent { label 'docker' }

    tools {
        maven 'Maven_3.9.6'
        jdk 'JDK_21'
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout Code') {
            steps {
                dir('source') {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: 'https://github.com/NanaQuaci/Phase3-Week2.git']]
                    ])
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t restassured_api_tests .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                bat '''
                    if not exist allure-results mkdir allure-results
                    docker run --rm ^
                    -v "%cd%\\allure-results:/app/allure-results" ^
                    restassured_api_tests
                '''
            }
        }

        stage('Generate Allure Report') {
            steps {
                // Make sure directory exists
                bat 'if not exist allure-report mkdir allure-report'

                // This requires Allure CLI to be installed and on PATH
                bat 'allure generate allure-results --clean -o allure-report'
            }
        }

        stage('Publish Allure Report in Jenkins') {
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

            // Publish JUnit XML results
            junit '**/target/surefire-reports/*.xml'

            // Optional Slack notification
            script {
                try {
                    slackSend(
                        channel: '#qa-notifications',
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
