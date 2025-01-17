def call(String projectName , String ImageTag){
sh "docker build -t ${projectName}:${ImageTag}"
}
