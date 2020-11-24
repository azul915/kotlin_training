package kia.sec2

import java.io.BufferedReader
import java.lang.NumberFormatException
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

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

fun readNumber(read: BufferedReader): Unit {
    val number = try {
        Integer.parseInt(read.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}

fun treeMap2() = run {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    binaryReps
}
