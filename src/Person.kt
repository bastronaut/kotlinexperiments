// automatically generated constructor with public field name
class Person(var name: String) {

    // String interpolation
    fun display() {
        println("display: $name")
    }

    // functions as first class citizens, pass lambda as argument
    fun displayLambda(func: (s:String) -> Unit) {
        func(name)
    }
}