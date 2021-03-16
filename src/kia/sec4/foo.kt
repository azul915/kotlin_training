package kia.sec4.foo

import java.io.Serializable

interface Clickable {
    fun click()
    // デフォルト実装
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm foucusable!")
}

class Button_1: Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    override fun click() {}
//    冗長
//    open override fun showOff() {}
    final override fun showOff() {}
}

class Foo {
    open fun foo() {}
}


abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}

//internal open class TalkativeButton : Focusable {
//    private fun yell() = println("Hey!")
//    protected fun whisper() = println("Let's talk!")
//}

//fun TalkativeButton.giveSpeech() {
//    yell()
//    whisper()
//}

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button_2: View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState : State {}
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
        when(e) {
           is Expr.Num -> e.value
           is Expr.Sum -> eval(e.left) + eval(e.right)
        }
