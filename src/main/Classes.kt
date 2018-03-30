package main

/**
 * Classes are final by default. This means we cant derive from a class by default. Same for methods, they are final
 * by default and dont allow overriding them. To undo it, you can use the keyword 'open'.
 * Kotlin classes are public by default. This is different than in java, where instead its
 * package-private. This is not used in Kotlin, it has an 'internal' keyword. This is visible for anything
 * compiled together
 * Kotlin supports Sealed classes, which is a fixed set of derivations (Enums on steroids?)
 */
open class Classes {
    var firstName: String = ""
    var lastName: String = ""

    open fun getName(): String = "$firstName $lastName"
}

class ClassesNotOpen {
    var firstName: String = ""
    var lastName: String = ""

    fun getName(): String = "$firstName $lastName"
}


/**
 * Compiler throws error: ClassesNotOpen  is final so not allowed
 */
//class SubClass : ClassesNotOpen() {}

/**
 * Allowed because Classes is open
 */
class SubClass: Classes() {
    // This is not allowed until you set getName to open (and mention the override keyword)
    override fun getName(): String {
        return "$firstName $lastName"
    }
}

/**
 * defined with abstract in name. Does not need to use 'open' keyword as obviosuly abstract classes are intended
 * to be extended
  */

abstract class AbstractClass {
    fun sayYo() {
        println("yo")
    }
}

/**
 * Experiment with Static methods: Kotlin deos not have a static keyword. To define Static classes you can use the
 * Companion Object. But this is not really the same it seems like. Docs:
 * Note that, even though the members of companion objects look like static members in other languages,
 * at runtime those are still instance members of real objects, and can, for example, implement interfaces.
 *
 * Can also use the @JvmStatic annotation to make it behave exactly the same as a static class?
 */
class TestStatic {
    companion object {
        fun sayYo() { print("yo") }

        @JvmStatic
        fun sayYoYo() { print("yoyo")}
    }
    // You define a single companion object to put it into, adding a second will give compiler 'duplicate companion
    // object':
    // companion object {}
}

class TestStaticCaller {

    fun main(args: String) {
        // Calling it from kotlin:
        TestStatic.sayYo();
        // To call it from Java:
        TestStatic.Companion.sayYo()

        TestStatic.sayYoYo()
    }

    /** This comiples into:
     *
    public static final class Companion {
        public final void sayYo()
        {
            String var1 = "yo";
            System.out.print(var1);
        }

        @JvmStatic
        public final void sayYoYo()
        {
            String var1 = "yoyo";
            System.out.print(var1);
        }
    }
     */
}

/** Sealed Class. Basically specify an abstract superclass, that contains its
 * extending classes (is-a relationship). Useful for restricted type of events happening.
 * Sealed classes useful when normally using case switch
  */
sealed class Event {
    class BigBang: Event()
    class Cataclysm(val cheer: String): Event()
    class Purge: Event() { fun sayYo() { println("yo")} }
    class LeavingitOut: Event()
}

fun testTheEvents(e: Event) {
    // When keyword sort of like case switch. Default not needed as you know the classes
    // that extend it
    when(e) {
        // is keyword for if
        is Event.BigBang -> print("big bang!")
        is Event.Cataclysm -> print(e.cheer)
        is Event.Purge -> e.sayYo() // compiled says 'smart cast' as it knows the type
    }
}

/**
 * Style preference: create the constructor on class definition
 */
class Constructors (var name: String) {
    // however , can also create a custom 2nd constructor, but requires calling the
    // primary constructor using this(). Could also call superclass with super()
    constructor (name: String, _age: Int) : this(name) {
        var age = _age
    }

    val height: Int
    // will run upon construction
    init {
        height = 10
    }
}

/**
 * Both the class and the constructor argument set to open in order to override them
 */
open class Animal (open var name: String) {

    fun printName() {
        println("$name")
    }
}

/**
 when extending from a class, the superclass constructor must be initialized
  */
class Dog (override var name: String, var color: String) : Animal(name) {
    fun printNameColor() {
        printName()
        println("$color")
    }
}


/**
 * Private constructor for e.g. Singletons. Cant have constructor but init blocks
 * are allowed for initialization code. Will be called lazily on first initializion.
 * Also thread safe
 */
object someSingleton {
    init {
        print("init!")
    }
}