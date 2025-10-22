
def call(Map config = [:]) {
    stage('Deploy Application') {
        echo "Step 5: Deploying application using Docker Compose..."
        sh """
            docker-compose up -d --build
        """
        echo "✅ Application deployed successfully!"
    }
}
