package kia.sec8

import java.util.concurrent.locks.Lock


fun twoAndThree(operation: (Int, Int) -> Int) {
    val res = operation(2, 3)
    println("The result is $res")
}

fun String.filter(predicate: (Char) -> Boolean): String{
    val sb = StringBuilder()
    for (i in 0 until length) {
        val element = get(i)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
   val result = StringBuilder(prefix)

   for ((index, element) in this.withIndex()) {
       if (index > 0) result.append(separator)
       result.append(element)
   }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToStringSample(separator: String = ", ", prefix: String = "", postfix: String = "", transform: (T) -> String = { it.toString()}): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(prefix)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString(separator: String = ", ", prefix: String = "", postfix: String = "", transform: ((T) -> String)? = null): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element) ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

enum class Delivery { STANDARD, EXPEDITED }
class Order(val itemCount: Int)
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 6 + 1.2 * order.itemCount }
}

data class Person(val firstName: String, val lastName: String, val phoneNumber: String?)
class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

data class SiteVisit(val path: String, val duration: Double, val os: OS)
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = filter(predicate).map(SiteVisit::duration).average()

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}

fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("After sync")

    val lo = LockOwner(l)
    val act = { println("act") }
    lo.run { act }
}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }
}
//
//fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
//    return TransformingSequence(this, transform)
//}

inline fun foo(inlined: () -> Unit, noinline notlInlined: () -> Unit) {

}