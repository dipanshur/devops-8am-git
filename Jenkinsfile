pipeline {
    agent any

    triggers {
        githubPush() // This enables the "GitHub hook trigger for GITScm polling"
    }

    tools {
        maven "M11"
    }
    

    stages {
        stage("Git Checkout") {
            steps {
        git branch: 'main',
        url: 'https://github.com/dipanshur/devops-8am-git.git',
        credentialsId: '05c90163-fd8a-46d8-8f86-2d81fdee6c46'
  }
        }
        
        stage('Build') {
            steps {
                // Use batch mode and skip tests for faster non-interactive builds
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Deploy') {
            steps {
                // Publish the generated WAR to the remote Tomcat webapps directory.
                // Ensure "Publish Over SSH" plugin is installed and 'JavaWebApp' is configured.
                sshPublisher(
                    continueOnError: false,
                    failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName: 'JavaWebApp',
                            verbose: true,
                            transfers: [
                                sshTransfer(
                                    sourceFiles: '',       // Path to the file(s) relative to workspace
                                    removePrefix: '',              // Strips 'build/' directory structure on target
                                    remoteDirectory: '',    // Appended to the Remote Directory in global config
                                    execCommand: '''
                                        sudo yum install -y java-1.8.0-openjdk-devel
                                        sudo yum install -y tomcat10
                                        sudo systemctl start tomcat10
                                        sudo systemctl enable tomcat10
                                        sudo systemctl status tomcat10
                                    ''' // Optional shell commands to run on the target server after transfer
                                ),
                                sshTransfer(
                                    sourceFiles: 'target//*.war',       // Path to the file(s) relative to workspace
                                    removePrefix: 'target',              // Strips 'build/' directory structure on target
                                    remoteDirectory: '/var/lib/tomcat10/webapps/',    // Appended to the Remote Directory in global config
                                    execCommand: '''
                                        echo "Deployment is done"
                                        sudo systemctl restart tomcat10
                                    ''' // Optional shell commands to run on the target server after transfer
                                )
                            ]
                        )
                    ]
                )
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo 'Build and deploy succeeded'
            archiveArtifacts artifacts: 'target/*.war', fingerprint: true
        }
        failure {
            echo 'Pipeline failed - check console output for details.'
        }
    }
}