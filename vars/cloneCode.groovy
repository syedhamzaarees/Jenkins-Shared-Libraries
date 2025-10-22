
def call(Map config = [:]) {
    stage('Clone Code') {
        echo "Step 1: Cloning the repository..."
        git url: config.repo ?: 'https://github.com/syedhamzaarees/Flask-based-web-application-with-Nginx-reverse-proxy-and-MySQL-database-fully-containerized-using-D.git',
            branch: config.branch ?: 'main'
        echo "✅ Code cloned successfully from ${config.repo}."
    }
}
