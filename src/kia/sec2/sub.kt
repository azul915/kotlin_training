package kia.sec2

import java.util.*

fun fizzBuzz(i : Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun treeMap(): TreeMap<Char, String> {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    return binaryReps
}

fun arrayListOutputWithIndex() {
    val list = arrayListOf("10", "11", "1001")
    for ((i, e) in list.withIndex()) {
        println("$i: $e")
    }
}

fun treeMap2() = run {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    binaryReps
}
