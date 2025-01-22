def call(String imageName, String imageTag) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Log in to Docker Hub
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        
        // Tag the Docker image (ensure it's tagged correctly before pushing)
        sh "docker tag ${imageName}:${imageTag} ${dockerHubUser}/${imageName}:${imageTag}"
        
        // Push the Docker image
        sh "docker push ${dockerHubUser}/${imageName}:${imageTag}"
    }
}
