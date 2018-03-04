package main;

public class Question() {
    val correctAnswer = "42"
    val correctAnswerIntTest = 42
    val question = "What is the answer"

    // seems by default kotlin creates getters, cannot create a getter
    // with the same name, compiler complains
//    fun getCorrectAnswer(): String {
//        return correctAnswer
//    }
    fun question(answer: String) {

        println("$question")

        // weird object constructor?
        val message:String
        // string comparison with == instead of .equals(), value comparison?
        if (answer == this.correctAnswer) {
            println("$answer")
            message = "yep"
        } else {
            println("surely not $answer")
            message = "nope"
        }
        print(message)
    }

    // test obj constructors
    constructor(param: String) : this()

    constructor(param: String, paramTwo: String) : this()

    fun assignThruIfStatement(answer: String) {

        // if statements are expressions in kotlin lol
        // it seems to replace the conditional ternary operation from java:
        // (condition) : if true ? if false , does not work
        val message = if (answer == correctAnswer) {
            "yep"
        } else {
            "nope"
        }
        print("Was it the right answer: $message")
    }
}
