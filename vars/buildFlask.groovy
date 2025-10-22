
def call(Map config = [:]) {
    stage('Build Flask App') {
        echo "Step 2: Building the Flask Docker image..."
        sh """
            docker build -t ${config.imageName ?: 'flask-app:latest'} ./flask_app
        """
        echo "✅ Flask image built successfully: ${config.imageName ?: 'flask-app:latest'}"
    }
}
