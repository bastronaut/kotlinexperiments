package main

// automatically generated constructor with public field name
// var is mutable (compiler creates a getter and setter),
// val is immutable and compiler will complain when assigning a new value
class PersonTwo(val name: String) {

    // String interpolation
    fun display() {
        println("display: $name")
    }

    // functions as first class citizens, pass lambda as argument
    fun displayLambda(func: (s:String) -> Unit) {
        func(name)
    }
}
// Compiler creates seperate class files. dunno why this feature
// does not seem that good idea to keep more classes in same file hehe
class PersonTwoInSameFile() {
    fun yo() {
        println("yo")
    }
}