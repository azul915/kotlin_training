package kia.sec6

import java.io.BufferedReader

fun strLenSafe(s: String?): Int = if (s != null) s.length else 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    allCaps.also { println(it) }
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}

fun strLenSafeSample(s: String?): Int = s?.length ?: 0

fun Person.countryNameSample(): String = company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
    val address = person.company?.address
            ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class PersonSample(private val firstName: String, private val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson: PersonSample = other as? PersonSample ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() * 37 + lastName.hashCode()
    }
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    private lateinit var myService: MyService

    fun setUp() {
        myService = MyService()
    }

    fun testAction() {

    }
}

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    } else {
        println("Input is $input")
    }
}

fun String?.isNullOrBlank(): Boolean = this == null || this.isBlank()

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHashCodeWithAny(t: T) {
    println(t.hashCode())
}

fun showProgresss(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println(percent)
}

data class PersonFoo(val name: String, val age: Int? = null) {
    fun isOlderThan(other: PersonFoo): Boolean? {
        if (age == null || other.age == null) return null
        return age > other.age
    }
}

fun piyo() {

    val i = 1
    val l: Long = i.toLong()

    val x: Int = 1
    val list: List<Long> = listOf<Long>(1L, 2L, 3L)
    println(x.toLong() in list)
    (x.toLong() in listOf(1L, 2L, 3L)).also { println(it) }
}

fun abc() {
    fun foo(l: Long) = println(l)

    val b: Byte = 1
    val l: Long = b + 1L

    foo(42)

    "1234".toInt().also { println(it) }

}

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result

}