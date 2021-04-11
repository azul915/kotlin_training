package kia.sec7
import java.beans.PropertyChangeListener
import java.math.BigDecimal
import java.time.LocalDate

fun sec7Output(): Any {
//    return invokePlus()
//    return invokePointSamplePlus()
//    return invokePointTimes()
//    return invokeCharTimes()
//    return invokeCompoundPlusOperator()
//    return invokeFoo()
//    return invokeBar()
//    return invokeUnaryMinus()
//    return invokeInc()
//    return invokeBigDecimalInc()
//    return invokeOverrideEqual()
//    return invokeOverrideCompareTo()
//    return invokeOverrideGetter()
//    return invokeOverrideSetter()
//    return invokeOverrideContains()
//    return invokeOverrideRangeTo()
//    return (0..10).forEach { println(it) }
//    return invokeOverrideClosedRangeIterator()
//    return invokeOverrideNameComponents()
//    return invokePrintEntries()
//    return invokePersonSampleEmail()
//    return invokePropertyChangeListener()
    return invokeExampleDeletion()
}

fun invokePlus() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
}

fun invokePointSamplePlus() {
    val p1 = PointSample(10, 20)
    val p2 = PointSample(30, 40)
    println(p1 + p2)
}

fun invokePointTimes() {
    val p = Point(10, 20)
    println(p * 1.5)
}

fun invokeCharTimes() {
    println('a' * 3)
}

fun invokeCompoundPlusOperator() {
    var point = Point(1, 2)
    point += Point(3,4)
    point.also { println(it) }
}

fun invokeFoo() {
    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])
}

fun invokeBar() {
    val list = arrayListOf<Int>(1, 2)
    list += 3
    val newList = list + listOf<Int>(4, 5)
    list.also { println(it) }
    newList.also { println(it) }
}

fun invokeUnaryMinus() {
    val p = Point(10, 20)
    println(-p)
}

fun invokeInc() {
    var p = Point(1, 1)
    println(p++)
    println(++p)
}

fun invokeBigDecimalInc() {
    operator fun BigDecimal.inc() = this + BigDecimal.ONE

    var bd = BigDecimal.ZERO

    println(bd++)
    println(++bd)
}

fun invokeOverrideEqual() {
    println(Point(10, 20) == Point(10, 20))
    println(Point(10, 20) != Point(10, 20))
    println(Point(10, 20) == null)
}

fun invokeOverrideCompareTo() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)
}

fun invokeOverrideGetter() {
    val p = Point(10, 20)
    println(p[1])
}

fun invokeOverrideSetter() {
    val p = MutablePoint(10,20)
    p[1] = 42
    println(p)
}

fun invokeOverrideContains() {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect)
    println(Point(5, 5) in rect)
}

fun invokeOverrideRangeTo() {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation)
}

fun invokeOverrideClosedRangeIterator() {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    daysOff.iterator().forEach { println(it) }
}

fun invokeOverrideNameComponents() {
//    val (name, ext) = splitFilename("example.kt")
//    println(name)
//    println(ext)

    val (name, extension) = splitFileName("example.kt")
    println(name)
    println(extension)
}

fun invokePrintEntries() {
    val map: Map<String, String> = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}

fun invokePersonSampleEmail() {
    val p = PersonSample("Alice")
    p.emails

    val ps2 = PersonSample2("Foo")
    ps2.emails
}

fun invokePropertyChangeListener() {
    val p = PersonHoge("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
            PropertyChangeListener { evt ->
                println("Property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
            }
    )

    p.age = 35
    p.salary = 2100

    val p2 = PersonFuga("Foo", 12, 40)
    p2.addPropertyChangeListener(
            PropertyChangeListener { e ->
                println("Property ${e.propertyName} changed from ${e.oldValue} to ${e.newValue}")
            }
    )

    p2.age = 13
    p2.salary = 41
}

fun invokeExampleDeletion() {
    val eg = Example()
    println(eg.p)
    eg.p = "Hello, I am new value"
}