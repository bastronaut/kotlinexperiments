/*
Decompile command to see Java class file:

java -cp "/Applications/IntelliJ IDEA.app/Contents/plugins/java-decompiler/lib/java-decompiler.jar" org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler /Users/bas/Documents/projects/kotlinexperiments/out/production/kotlinexperiments/Person.class /Users/bas/Documents/projects/kotlinexperiments/out/production/kotlinexperiments/
 */


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