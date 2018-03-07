package main

/**
 * When you dont define a class, kotlin compiler generates a class ->
 * Main.Question creates class MainKt (check run profile)
 */
fun main(args: Array<String>) {

    val wrongNr = "43"

    // compiler infers q is of type Quesiton
    var q = Question()
//    q.question(wrongNr)
//    q.question("42")

    // explicitly state the variable is of a type
    var qTwo:Question = Question()

//    testNullable()
//    testWhenStatement()
//    testAssignThruIfExpression()
//    testAssignThruTryExpression()
    testRangeLoop()
}

fun testWhenStatement() {
    var q = Question()
    q.whenStatement("yo")
}

fun testAssignThruIfExpression() {
    val q = Question()
    q.assignThruIfStatement("43")
    q.assignThruIfStatement("42")
}
fun testAssignThruTryExpression() {
    var q = Question()
    q.assignThruTryStatement("derp")
}

fun testRangeLoop() {
    for (i in 1..10) {
        println(i)
    }

    for (i in 1..10 step 2) {
        print(i)
    }

    // inclusive range / closed range
    for (i in 10 downTo 4 step 2) {
        print(i)
    }

    // exclusive 10, goes untli 9
    for (i in 1 until 10) {
        print(i)
    }

    var numbers = listOf(1, 2, 3, 4, 5)
    for (i in numbers) print(i)


//    with an index.
    for ((index, elemt) in numbers.withIndex()) {
        println("the index is $index")
    }
    // can also range over other stuff like strings
    var stringRange = listOf('a'..'z').flatten()
//    println(stringRange)
    for (i in stringRange) print(i)
}

fun testLambda() {
    // var is mutable
    var name = "bas"
    // val is immutable
    val bas = Person(name)
    val basTwo = PersonTwo(name)

    bas.display()
    basTwo.display()

    // pass (anonymous) methods as arguments
    bas.displayLambda(fun (name: String) {
        println("Anonymous method passed! Name is: $name")
    })

    // or named methods by reference
    bas.displayLambda(::passMethod)
}

fun testMapIterate() {
    var ages = HashMap<String, Int>()
    ages["Bas"] = 12
    ages["henk"] = 15
    ages["yolo"] = 13

//    for... in of collection
    for ((name, age) in ages) {
        print("$name is $age")
    }

}
fun passMethod(name: String) {
    println("method passed! name: $name")
}

fun testNullable(): String{
    // ? tells compiler explicitly it can be null. Otherwise you cannot assign null
    // If a variable can be null, we must always test for null
    var a:Question? = Question()
    val b:Question? = null
//    val c:Question = null  // not allowed compile error

    // because its nullable, we must also test for it or compilation will fail.
    // kotlins way of preventing nullpointers prolly
//    if (a.correctAnswer == "yo") { } // doesnt work
    if (a != null) {}

    // better: null test in the evaluation:
    return if (a?.correctAnswer == "42") "yay" else "nope"
}

// can also add nullable value to return type
fun returnPossibleNull(answer: String): String? {
    return if ("42" == answer) "yep" else null
}