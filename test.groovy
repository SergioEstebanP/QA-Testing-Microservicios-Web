//Pipeline
node {
    try{
        currentBuild.result = 'SUCCESS'
        stage('Clone') {
            dir('C:/Program Files (x86)/Jenkins/workspace/Pipeline/QA-Testing-Microservicios-Web') {
                deleteDir()
            }
            bat 'git clone https://github.com/SergioEstebanP/QA-Testing-Microservicios-Web'
            echo "Clone done ..."
        }
        stage('Build') {
            dir('C:/Program Files (x86)/Jenkins/workspace/Pipeline/QA-Testing-Microservicios-Web'){
                timeout(time:2,unit:'MINUTES'){
                    if (isUnix()) {
                        sh './gradlew clean'
                    }
                    else {
                        bat 'xxxxxx '

                    }
                }
            }
        }

        stage('Publishing Test Report') {

        }

    } catch(err){
        echo "Caught: ${err}"
        currentBuild.result = 'FAILURE'
    }
}