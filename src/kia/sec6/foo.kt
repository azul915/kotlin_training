package kia.sec6

fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    allCaps.also { println(it) }
}