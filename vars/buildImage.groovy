#!usr/bin/env groovy

// import Docker file
// import com.example.Docker
// src/com.example/Docker.groovy
def call(String imageName) {
    // create a new instance of class Docker, pass the context this, call method with imagename
    // reason to pass this is to have various jenkins methods like withCredentials etc available in the class 
    // return new Docker(this).buildDockerImage(imageName)
    // since import didnt work, revert
    echo "building docker image"
    withCredentials([usernamePassword(credentialsId:'dockerhub-login',passwordVariable: 'PASS',usernameVariable:'USER')]){
        sh "docker build -t $imageName ."
        sh "echo $PASS docker login -u $USER --password-stdin"
        sh "docker push $imageName"
        // pranavpo/my-repo:2.0
    }
}
