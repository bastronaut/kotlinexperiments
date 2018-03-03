/**
 * When you dont define a class, kotlin compiler generates a class ->
 * First.kt creates class FirstKt (check run profile)
 */
fun main(args: Array<String>) {

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

fun passMethod(name: String) {
    println("method passed! name: $name")
}