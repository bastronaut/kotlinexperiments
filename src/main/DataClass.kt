package main;

fun main(args: Array<String>) {
    val uno = DataClass(1, "yo")
    val dos = DataClass(2, "bye")
    val tres = DataClass(2, "bye")

    // When class is defined as data class, equals == is not looking at address space but at values in object
    // it seems
    println (uno == dos)
    println (dos == tres)

    // Get a automatically created useful toString
    println(tres)

    // Comes with a copy() method
    val tresTwo = tres.copy()
    println(tresTwo)

    // Can also modify the values?
    val tresThree = tres.copy(5)
    println(tresThree)
}
/**
 * Data class, automatically immutable, creates tostring and equals, and some other benefits
 */
data class DataClass(val id: Int, val name: String) {

}



