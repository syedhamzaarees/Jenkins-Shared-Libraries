
def call(Map config = [:]) {
    stage('Push to Docker Hub') {
        echo "Step 4: Pushing ${config.imageName ?: 'flask-app:latest'} to Docker Hub..."

        withCredentials([usernamePassword(
            credentialsId: config.credentialsId ?: 'dockerHubCreds',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )]) {
            sh '''
                echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin
            '''
            sh """
                docker image tag ${config.localImage ?: 'flask-app:latest'} $dockerHubUser/${config.repoName ?: 'flask-app'}:${config.tag ?: 'latest'}
                docker push $dockerHubUser/${config.repoName ?: 'flask-app'}:${config.tag ?: 'latest'}
            """
        }

        echo "✅ Image pushed to Docker Hub successfully."
    }
}
