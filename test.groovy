pipeline {
    agent {
        docker {
            image: "python-slim"
            args: '--user root'
        }
    }
    tools {
        Maven "M11"
    }

    parameters {
        string(name: "ENV", defaultValues: "dev", description: "select the env")
    }

    environment {
        APP_VERSION: 1.0.0
        GIT_CREDENTIALS = credentials('git-credential-id')
    }

    stages {
        stage("Build") {
            steps {
                scripts 1
                echo "Build the env: ${params.ENV} for APP_Version = ${env.APP_VERSION}"
                sh yum install tomcat10
            }
        }

        stage("Git") {
            steps {
                git branch: "main", url: "sfjlash/" 
                sh 'git clone https://$GIT_CREDENTIALS@github.com/reponame'
            }
        
        }

        stage("Deploy") {
            steps {
                script
            }
        }

        stage("test Parallel") {
            parallel {
                stage("P1") {
                    steps{

                    }
                }
                stage("P2"){
                    steps{
                        try {
                            sh "exit 1"
                        }
                        catch (Exceprion e) {
                            sh bash bootstrap1.sh 
                        }
                    }
                }
            }
        }
    }
    post {
        success {
            echo "Build Successful"
        }
        failure {
            echo "Failed"
        }
    }
}