/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package jenkins.shared.library

class App {
    String getGreeting() {
        return 'Hello World!'
    }

    static void main(String[] args) {
        println new App().greeting
    }
}