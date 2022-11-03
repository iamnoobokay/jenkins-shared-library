#!usr/bin/env groovy

// import Docker file
import src.com.example.Docker

def call(String imageName) {
    // create a new instance of class Docker, pass the context this, call method with imagename
    // reason to pass this is to have various jenkins methods like withCredentials etc available in the class 
    return new Docker(this).buildDockerImage(imageName)
}
