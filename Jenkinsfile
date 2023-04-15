pipeline{
    agent any
    stages {
        stage("Git checkout"){
            script(
                git branch: 'main', url: 'https://github.com/aliloumehdi/cicdimpl.git'
            )
        }
    }
}