pipeline{
    agent any
    stages {
        stage("Git checkout"){
            steps {

                script{ git branch: 'main', url: 'https://github.com/aliloumehdi/cicdimpl.git' }
            
            }
        
                
            
        }
        stage("Empty Stage "){
            steps {

                script{ echo "Empty stage" }
            
            }
        
                
            
        }
    }
}