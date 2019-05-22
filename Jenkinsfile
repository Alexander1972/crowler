pipeline{
    agent any
    stages{
      stage('Init'){
        steps{
          echo "Testing ... "
        }
      }
      stage('Build'){
        steps{
          echo "Building ... "
            shellFunction()
        }
      }
      stage('Deploy'){
        steps{
          echo "Deploying ... "
        }
      }
    }
  }
void shelFunction(){
    sh 'echo from shell function'
}
