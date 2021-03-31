package kia.sec6

fun sec6Output(): Any {
//    return invokeStrLenSafe()
    return invokePrintAllCaps()
}

fun invokeStrLenSafe() {
    val x: String? = null
    strLenSafe(x).also { println(it) }

    strLenSafe("abc").also { println(it) }
}

fun invokePrintAllCaps() {
    printAllCaps("abc")
    printAllCaps(null)
}