package kia.sec7

import java.time.LocalDate

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point) return false
        return other.x == x && other.y == y
    }
}

data class PointSample(val x: Int, val y: Int)
operator fun PointSample.plus(other: PointSample): PointSample {
    return PointSample(x + other.x, y + other.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String = toString().repeat(count)

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    // this.add(element)
    add(element)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun Point.inc(): Point {
    return Point(x + 1, y + 1)
}

class Person(private val firstName: String, private val lastName: String): Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int) {
    operator fun set(index: Int, value: Int) {
        when(index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point) {
    operator fun contains(p: Point): Boolean {
        return p.x in upperLeft.x until lowerRight.x &&
                p.y in upperLeft.y until lowerRight.y
    }
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            override fun hasNext(): Boolean = current <= endInclusive
            override fun next() = current.apply { current = plusDays(1) }
        }

class FooPoint(private val x: Int, private val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

data class NameComponents(val name: String, val extension: String)
fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

fun splitFileName(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}
