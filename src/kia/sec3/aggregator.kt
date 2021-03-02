package kia.sec3

import java.util.HashMap
import kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated

fun sec3Output(): Any {
//    return invocatorJoinToString()
//    return invocatorJoinToStringWithDefaultParam()
//    return invocatorJoinToStringHasDefaultArgs()
//    return invocatorLastChar()
//    return testExpansionProperty()
//    val naturalNumbers = generateSequence(0) { it + 1}
//    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
//    return numbersTo100.sum()
//    return makeCollections()
//    return bar()
//    return invocatorJoin()
//    return buttonClicked()
//    return iamaView()
//    return listLastElement()
//    return setMaxElement()
//    return foo()
//    return piyo()
//    return hoge()
//    return fuga()
//    return parsePath("/Users/yole/kotlin-book/chapter.adoc")
//    return parsePathByRegex("/Users/yole/kotlin-book/chapter.adoc")
    return asciiart().trimMargin(".")
}

data class Foo(val s: HashSet<Int> = hashSetOf(1, 7, 53),
                val l: ArrayList<Int> = arrayListOf(1, 7, 53),
                val h: HashMap<Int, String> = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three"))
fun makeCollections(): String {
    val (set, list, map) = Foo()
    return "set type is ${set.javaClass}, list type is ${list.javaClass}, map type is ${map.javaClass}"
}

fun bar(): String {
    val strings = listOf("first", "second", "fourteenth")
    val numbers = setOf(1, 14, 2)
    return """list of string last element is ${strings.last()}
        |set of numbers max element is ${numbers.maxOrNull()}""".trimMargin()
}

fun invocatorJoinToString(): String {
    val list = listOf(1, 2, 3)
    return joinToString(list, "; ", "(", ")")
}

fun invocatorJoinToStringWithDefaultParam(): String {
    val list = listOf(1, 2, 3)
    return joinToString(list, separator = " ", prefix = " ", postfix = ".")
}

fun invocatorJoinToStringHasDefaultArgs(): String {
    val list = listOf(1, 2, 3)
    return """
        ${joinToStringHasDefaultArgs(list, ", ", "", "")}
        ${joinToStringHasDefaultArgs(list)}
        ${joinToStringHasDefaultArgs(list, "; ")}
    """.trimIndent()
}

fun invocatorLastChar(): Char {
    return "Kotin".lastChar()
}

fun testExpansionProperty(): String {
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    return sb.toString()
}

fun invocatorJoin(): String {
    return listOf("one", "two", "eight").join(" ")
}

fun buttonClicked(): Unit {
    val view: View = Button()
    view.click()
}

fun iamaView(): Unit {
    val view: View = Button()
    view.showOff()
}

fun listLastElement(): String {
    val strings = listOf("first","second","fourteenth")
    return strings.last()
}

fun setMaxElement(): Int {
    val numbers = setOf(1,14,2)
    return numbers.max()!!
}

fun foo(): Unit {
    val numbers = intArrayOf(1,2,3)
    printNumbers(*numbers)
}

fun piyo(): Unit {
    val numbers = intArrayOf(1,2,3)
    printNumbers(10,20,*numbers,30,40)
}

fun hoge(): List<String> {
    return "12.345-6.A".split("\\.|-".toRegex())
}

fun fuga(): List<String> {
    return "12.345-6.A".split(".")
}

fun parsePath(path: String): String {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    return "Dir: $directory, name: $fileName, ext: $extension"
}

fun parsePathByRegex(path: String): Unit {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun asciiart(): String {
    val kotlinLogo = """| //
                       .|//
                       .|/ \"""
    return  kotlinLogo
}

private fun printNumbers(vararg numbers: Int) {
    for (num in numbers) {
        println(num)
    }
}
