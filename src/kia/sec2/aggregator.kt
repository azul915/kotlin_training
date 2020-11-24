package kia.sec2

fun sec2Output(): Any {
//    return blue()
//    return expr()
//    return expr2()
//    return expr3()
//    return fizzBuzzOutput()
//    return treeMapOutput()
    return arrayListOutputWithIndex()
}

fun blue(): String = "rgb: ${Color.BLUE.rgb()}"

fun expr(): Int {
    return eval(Sum(Sum(Num(1), Num(2)), Num(4)))
}

fun expr2(): Int {
    return evalFormula(Sum(Sum(Num(1), Num(2)), Num(4)))
}

fun expr3(): Int {
    return evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4)))
}

fun fizzBuzzOutput() {
    for (i in 100 downTo 1 step 2) {
        print("${fizzBuzz(i)} ")
    }
}

fun treeMapOutput() {
    val binReps = treeMap()
    for ((letter, binary) in binReps) {
        println("$letter = $binary")
    }
}
