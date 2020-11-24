package kia.sec1
import kia.sec1.person.Person
import kia.sec1.rectangle.Rectangle

fun bobsStatus(): String {
    val person = Person("Bob", true)
    return "name: ${person.name}, isMarried: ${person.isMarried}"
}

fun checkIsSqure(height: Int, width: Int): String {
    val rectangle = Rectangle(height, width)
    return "rectangle.isSquare: ${rectangle.isSquare}"
}