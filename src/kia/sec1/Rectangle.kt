package kia.sec1.rectangle

class Rectangle (
        private val height: Int,
        private val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}