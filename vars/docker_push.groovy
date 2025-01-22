def call(String projectName, String ImageTag) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Log in to Docker Hub
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    }
    // Push the Docker image
    sh "docker push ${dockerHubUser}/${projectName}:${ImageTag}"
}
