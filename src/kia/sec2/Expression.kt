package kia.sec2

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
    if (e is Num) {
//        val n = e as Num
        val n = e
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown Expression")

}

fun evalFormula(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> evalFormula(e.left) + evalFormula(e.right)
            else -> throw IllegalArgumentException("Unknown Expression")
        }

fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown Expression")
        }
