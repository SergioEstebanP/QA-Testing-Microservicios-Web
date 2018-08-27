//Pipeline
node {
   try{
       currentBuild.result = 'SUCCESS'

        stage ('Clone') {
            dir('/var/jenkins_home/workspace/Pipelines/QA-Testing-Microservicios-Web') {
                deleteDir()
            }
            sh "git clone https://github.com/SergioEstebanP/QA-Testing-Microservicios-Web"
            echo "Repository cloned"
        }

        stage('Build') {
            dir ('QA-Testing-Microservicios-Web'){
                if (isUnix()) {
                    sh './gradlew clean'
                }
                else {
                    bat './gradlew.bat clean'
                }
            }

        }

       stage('Test') {
            dir ('QA-Testing-Microservicios-Web'){
                if (isUnix()) {
                    sh './gradlew test'
                }
                else {
                    bat './gradlew.bat test'
                }
            }

        }

        stage('Results') {
            dir ('QA-Testing-Microservicios-Web'){
                if (isUnix()) {
                    sh './gradlew aggregate'
                }
                else {
                    bat './gradlew.bat aggregate'
                }
            }

        }

   } catch(err){
       echo "Caught: ${err}"
       currentBuild.result = 'FAILURE'
   }
}
