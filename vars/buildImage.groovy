#!usr/bin/env groovy
def call(){
     echo "building docker image"
    withCredentials([usernamePassword(credentialsId:'dockerhub-login',passwordVariable: 'PASS',usernameVariable:'USER')]){
        sh 'docker build -t pranavpo/my-repo:2.0 .'
        sh "echo $PASS docker login -u $USER --password-stdin"
        sh 'docker push pranavpo/my-repo:2.0'
    }
}