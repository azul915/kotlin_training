package kia.sec4

fun sec4Output(): Any {
//    return Button().click()
//    return Button().showOff()
    return invokeButton()
}

fun invokeButton() {
    val button = Button()
    button.showOff()
    button.setFoucus(true)
    button.click()
}