package kia.sec4

interface Clickable {
    fun click()
    // デフォルト実装
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFoucus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm foucusable!")
}

class Button: Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}