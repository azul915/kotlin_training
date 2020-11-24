package kia.sec3

fun sec3Output(): Any {
//    return invocatorJoinToString()
//    return invocatorJoinToStringWithDefaultParam()
    return invocatorJoinToStringHasDefaultArgs()
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
