#!usr/bin/env groovy
def call(String imageName){
     echo "building docker image"
    withCredentials([usernamePassword(credentialsId:'dockerhub-login',passwordVariable: 'PASS',usernameVariable:'USER')]){
        sh "docker build -t $imageName ."
        sh "echo $PASS docker login -u $USER --password-stdin"
        sh "docker push $imageName"
        // pranavpo/my-repo:2.0
    }
}