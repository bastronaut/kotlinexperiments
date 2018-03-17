@file:JvmName("DisplayFunctions")
package main

/* Calling functions from Java
Kotlin compiles a class, that is named according to Filename.
If filename is Functions.kt, class will be FunctionsKt.
Any top level functions are added as Static functions to the class
(display() and max() in this case)

If you want a different name, you can use an annotation:
@file:JvmName({name of class})

See FunctionsJava.java
*/
fun main(args: Array<String>) {
//    display()
//    print(max(2, 5))
//    log("yo", 1)

// Used named parameters allows switching params around if needed.
// Pure Kotlin functionality, not supported in Java
//    println(log(logLevel = 5 , message = "yo"))
//    println(log(message = "yo"))
    // not allowed to mix them though, must name all if naming one
//    println(log(message = "yo", 6)) // compile error

    testExtensionFunction()

}

/* No void in kotlin, simply leave off the return type
* fun display() : void { } //nope
*/
fun display() {
    println("no returns")
}

/* Function Expressions in kotlin:
* */
fun max(a: Int, b: Int) : Int = if (a > b) a else b

/* Default parameters, useful for e.g. upgrading APIs
Will use 5 as default.

For Java, can use an annotation to generate overloaded methods,
which will allow calling it from java without passing the Default parameter
* */
@JvmOverloads
fun log(message: String, logLevel: Int = 5) {
    println("Log level: $logLevel , message: $message")
}

/* No annotation, will require the 2nd param when called from Java
* */
fun logNoOverload(message: String, logLevel: Int = 5) {
    println("Log level: $logLevel , message: $message")
}

/*  Extension Functions
* allows 'adding' functions to classes you dont own.
* Kotlin simply generates static functions, cuts down on util classes.
* Seems useful for mostly helpful methods
*
* IMO feels a little dangerous?
*
* See for ex the following stupid method that would probably normally be in a
* Util class:
* */
fun printMiddleCharacter(str: String) : String {
    val length = str.length;
    if (length > 1) {
        return str.slice(IntRange(length / 2, length / 2))
    }
    return str;
}
/*  Extension class, mention the classname first (called the Receiver).
Whichever object its being called on is replaced with "this"
 */
fun String.printMiddleCharacterExtension() : String{
    val length = this.length;
    if (length > 1) {
        return this.slice(IntRange(length /2 , length / 2))
    }
    return this;
}

fun testExtensionFunction() {
    println("middle char:")
    println(printMiddleCharacter("x"))
    println(printMiddleCharacter("xy"))
    println(printMiddleCharacter("xyz"))
    println(printMiddleCharacter("wxyz"))
    println(printMiddleCharacter("vwxyz"))

    println("vwxyz".printMiddleCharacterExtension())
}

