package kia.sec4

import kia.sec4.piyo.*
import java.io.File

fun sec4Output(): Any {
//    return Button().click()
//    return Button().showOff()
//    return invokeButton()
//    return invokeClient()
//    return bobCopy()
//    return useRectangle()
//    return useRectange_2()
//    return countSet()
//    return declareComplatorByObject()
//    return filesComparator()
//    return nestedComparator()
//    return callCompanionObject()
//    return callSecondaryConstructor()
    return callNamedCompanionObject()
}

//fun invokeButton() {
//    val button = Button()
//    button.showOff()
//    button.setFocus(true)
//    button.click()
//}

fun invokeClient(): String {
    val client = Client("Alice", 342562)
    return client.toString()
}

fun bobCopy(): String {
    val bob = Client("Bob", 973293)
    val newBob = bob.copy(postalCode = 382555)
    return newBob.toString()
}

fun countSet(): Unit {
    val cset = CountingSet<Int>()
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}

fun useRectangle(): Unit {
    val rect = Rectangle("rectangle", 10, 10)
    val window = Window(rect)
    println(window.name)
    println(window.area())
}

fun useRectange_2(): Unit {
    val rect = Rectangle("rectangle_2", 10, 20)
    val window = Window_2(rect)
    println(window.name)
    println(window.area())
}

fun useObject(): Unit {
    Payroll.allEmployees.add(PersonSample("foo"))
    Payroll.calculateSalary()
}

fun declareComplatorByObject(): Unit {
    println(CaseInsensitiveFilecomparator.compare(File("/User"), File("/user")))
}

fun filesComparator(): Unit {
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFilecomparator))
}

fun nestedComparator(): Unit {
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}

fun callCompanionObject(): Unit {
    println(CompanionSampleA.bar())
}

fun callSecondaryConstructor(): Unit {
    val subscribingUser = FooUser.newSubscribingUser("bob@gmail.com")
    val facebookUser = FooUser.newFacebookUser(4)
    println(subscribingUser.nickname)
}

fun callNamedCompanionObject(): Unit {
    val person = FooPerson.Loader.fromJSON("{name: 'Dmitry'}")
    println(person.name)
    val person2 = FooPerson.fromJSON("{name: 'Brent'}")
    println(person2.name)
}