package kia.sec4

import kia.sec4.piyo.Client

fun sec4Output(): Any {
//    return Button().click()
//    return Button().showOff()
//    return invokeButton()
//    return invokeClient()
//    return bobCopy()
//    return useRectangle()
    return useRectange_2()
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