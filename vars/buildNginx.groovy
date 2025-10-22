
def call(Map config = [:]) {
    stage('Build Nginx App') {
        echo "Step 3: Building the Nginx Docker image..."
        sh """
            docker build -t ${config.imageName ?: 'nginx-app:latest'} ./nginx
        """
        echo "✅ Nginx image built successfully: ${config.imageName ?: 'nginx-app:latest'}"
    }
}
