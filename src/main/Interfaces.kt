package main

/**
 * Inteface is public by default
 */
interface Time {
    // Default params allowed in interface
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0);

    /** can also provide a default implementation to avoid all classes that
     * implement the interface from having to add it. Syntax is just
     * using the = character
     */
    fun setTime(yolotime: YoloTime) = {
        setTime(yolotime.hours)
    }
}

class YoloTime {
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
}
// no implements and extends keyword, colon is used for both extension and interface
class YetiTime : Time {
    // must explicitly mention override
    override fun setTime(hours: Int, mins: Int, secs: Int) { }

}