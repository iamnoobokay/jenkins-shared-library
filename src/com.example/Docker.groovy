#!usr/bin/env groovy

package com.example

// implements serializable is used to store the state of a pipeline. for eg: while choosing an option from dropdown, the pipeline is paused.
class Docker implements Serializable{
    def script
    Docker(script){
        // this passed from the buildimage as context is assigned to a variable here.
        this.script = script
    }

    def buildDockerImage(String imageName){
        script.echo "building docker image"
        script.withCredentials([script.usernamePassword(credentialsId:'dockerhub-login',passwordVariable: 'PASS',usernameVariable:'USER')]){
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS docker login -u $script.USER --password-stdin"
            script.sh "docker push $imageName"
            // pranavpo/my-repo:2.0
        }
    }
}