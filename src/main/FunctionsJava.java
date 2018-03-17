package main;
/*
Calling functions from Java
Kotlin compiles a class, that is named according to Filename.
If filename is Functions.kt, class will be FunctionsKt.
Any top level functions are added as Static functions to the class
(display() and max() in this case)

If you want a different name, you can use an annotation:
@file:JvmName({name of class})

See Functions.kt
*/
public class FunctionsJava {

    public static void main(String[] args) {
//        Default name if @file annotation is not given
//        FunctionsKt.display();
//        System.out.println(FunctionsKt.max(2,1));

        // Name with @file annotation
        DisplayFunctions.display();
        System.out.println(DisplayFunctions.max(2, 1));

        DisplayFunctions.log("yo");
        // Optional log level because of @JvmOverloads annotation
        DisplayFunctions.log("yo", 6);
//        DisplayFunctions.logNoOverload("yo" ); // compile error
        DisplayFunctions.logNoOverload("yo", 5 ); // compile error
    }
}
