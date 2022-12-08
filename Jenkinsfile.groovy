pipeline {
    agent any

    environment {
        EXECUTE = 'false'
    }

    stages{
         stage ('First') {
            steps {
                script{
                env.EXECUTE = 'true'
                }
                echo 'Updating Second Stage to the Second Stage' 
                    }
                }
                stage ('Second') {
                    when {
                        expression{
                         env.EXECUTE = 'true'
                        }
                    }
                    steps {
                        echo 'The Second stage can be executed'
                    }
                }
        
                stage ('Third'){
                    when {
                        expression {
                        env.EXECUTE != 'false'
                        }
                    }
                    steps {
                         echo 'This stage has to be skipped'
                    }
                }
    
        }
}