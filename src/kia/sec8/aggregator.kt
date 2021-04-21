package kia.sec8

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun sec8Output(): Any {
//    val sum = { x: Int, y: Int -> x + y }
//    val action = { println(42) }
//    sum(1, 99).also { println(it) }
//    action()
//
//    val sumSample: (Int, Int) -> Int = { x, y -> x + y }
//    val actionSample: () -> Unit = { println(42) }
//    var canReturnNull: (Int, Int) -> Int? = { x, y -> null }
//    var funOrNull: ((Int, Int) -> Int)? = null
//    return "fin"
//    invokeTwoAndThree()
//    return println("ab1c".filter { it in 'a'..'z' })
//    return invokeJoinToStringSample()
//    return invokeGetShippingCostCalculator()
//    return invokeContractListFilters()
//    return invokeJoinToString()
//    val list = listOf("hoge", "fuga", "foo", "bar")
//    list.also { println(it) }
//    list.apply { println(this) }
//    with(listOf("hoge", "fuga", "foo", "bar")) {
//        println(this)
//    }
//    return invokeContractListFilters()
//    return invokeStdOutLog()
    return invokeReentrantLock()
}

fun invokeTwoAndThree() {
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
}

fun invokeJoinToStringSample() {
    val letters = listOf<String>("Alpha", "Beta")
    println(letters.joinToStringSample())

    println(letters.joinToStringSample { it.toLowerCase() })
    println(letters.joinToStringSample(separator = "! ", postfix = "! ", transform = { it.toUpperCase() }))
}

fun invokeJoinToString() {
    val letters = listOf<String>("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString { it.toLowerCase()})
    println(letters.joinToString(separator = "# ", postfix = "# ", transform = { it.toUpperCase() }))
}

fun invokeGetShippingCostCalculator() {
    val calc: (Order) -> Double = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calc(Order(3))}")
}

fun invokeContractListFilters() {
    val contacts = listOf(Person("Dmitry", "Jemerov", "123-4567"), Person("Svetlana", "Isakova", null))
    val contactListFilters = ContactListFilters()
    with (contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }

    println(contacts.filter(contactListFilters.getPredicate()))
}

fun invokeStdOutLog() {
    val log: List<SiteVisit> = listOf(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOWS),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID))
    val averageWindowsDuration = log.filter { it.os == OS.WINDOWS }.map(SiteVisit::duration).average()
    averageWindowsDuration.also { println(it) }
    log.averageDurationFor(OS.WINDOWS).also { println(it) }
    log.averageDurationFor(OS.MAC).also { println(it) }

    val averageMobileDuration = log.filter { it.os in setOf<OS>(OS.IOS, OS.ANDROID) }.map(SiteVisit::duration).average()
    averageMobileDuration.also { println(it) }

    log.averageDurationFor { it.os in setOf<OS>(OS.IOS, OS.ANDROID) }.also { println(it) }
    log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" }.also { println(it) }

}

fun invokeReentrantLock() {
    val obj: Lock = ReentrantLock()
    println("Before sync")
    synchronized(obj) {
        println("Action")
    }
    println("After sync")
}