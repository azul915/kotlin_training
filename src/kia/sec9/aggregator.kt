package kia.sec9

fun sec9Output(): Any {
//    return invokeGenericFunction()
//    return invokeReadFirstLineFromFile()
//    return invokeLookForAlice()
//    return foo()
    return invokeLookForAlice()
}

fun invokeGenericFunction() {
    val letters = ('a'..'z').toList()
    letters.slice<Char>(0..2).also { println(it) }
    letters.slice(10..13).also { println(it) }
}

fun invokeGenericLambdaFunction() {
    val authors = listOf("Dmitry", "Svetlana")
    val readers = mutableListOf<String>("Foo", "Bar")
    readers.filter { it !in authors }
}

fun invokeReadFirstLineFromFile() {
    val text = """
        fun <T> Lock.withLock(action: () -> T): T {
            lock()
            try {
                return action()
            } finally {
                unlock()
            }
        }
    """.trimIndent()

    readFirstLineFromFile(text)
}

fun invokeLookForAlice() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    lookForAlice(people)
    lookForAliceLambda(people)
    lookForAliceLabel(people)
    lookForAliceFunctionName(people)
    lookForAliceFoo(people)
}

fun foo() {
    println(
            StringBuilder().apply sb@{
                listOf(1, 2, 3).apply {
                    this@sb.append(this.toString())
                }
            }
    )

}
