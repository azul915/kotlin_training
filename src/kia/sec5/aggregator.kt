package kia.sec5

import java.io.File

fun sec5Output(): Any {
//    return transformNames()
//    return bar()
//    return piyo()
//    return sandbox()
//    return fuga()
//    return invocationLambdaSandbox()
//    return file()
    return invokeAlphabet()
}

fun foo(): Person? {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.maxByOrNull({ p: Person -> p.age })
    people.maxByOrNull() { p: Person -> p.age }
    people.maxByOrNull { p: Person -> p.age }
    return people.maxByOrNull { it.age }
}

fun transformNames(): String {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val names: String = people.joinToString(separator = " ", transform = { p: Person -> p.name})
    println(names)
    return people.joinToString(" ") { p: Person -> p.name }
}

fun bar() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error: ")
}

fun piyo() {
    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
}

fun sandbox() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
//    { println(42) }
    run { println(42) }
}

fun hoge() {
    val getAge = Person::age
}

fun fuga() {
    cp()
    val predicate = Person::isAdult
}

fun invocationLambdaSandbox() {
    lambdaSandbox()
}

fun file() {
    val file = File("/Users/svtk/.HiddenDir/a.txt")
    file.isInsideHiddenDirectory().also { println(it) }
}

fun invokeAlphabet() {
    alphabet().also { println(it) }
    alphabet2().also { println(it) }
    alphabet3().also { println(it) }
    alphabet4().also { println(it) }
}
