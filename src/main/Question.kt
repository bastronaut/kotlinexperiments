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
        println(message)

        println("hashcodes:")
        println(answer.hashCode())
        println(this.correctAnswer.hashCode())
        println(this.correctAnswer.toString())
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

    // similar to if, try catch is also an expression?
    fun assignThruTryStatement(number: String) {

        // expression to assign to variable
        val nr:Int = try {
            // ps simply using Java wrapper class of primitive int
            Integer.parseInt(number)
        } catch (e:NumberFormatException) {
            -1
        }

        // OR ALTERNATIVELY, use nullable type
        val nrMaybe:Int? = try {
            Integer.parseInt(number)
        } catch(e:NumberFormatException) {
            null // can now return null and we check it on use
        }

        // not checking for null?
        print(nrMaybe) // print null works fine btw no nullpointer
    }

    // When replaces case switch statement. apparantly more powerful
    fun whenStatement(word: String) {

        when (word) {
            "yo" -> print("yo $word yoyo")
            "bye" -> print("bye $word")
            else -> print ("nuttin")
        }

    }
}
