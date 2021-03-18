package kia.sec4

class DelegatingCollection<T>: Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int
    get() = innerList.size
    override fun isEmpty() = innerList.isEmpty()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
}

class DelegatingCollection_2<T>(private val innerList: Collection<T> = ArrayList<T>()): Collection<T> by innerList {}

class CountingSet<T>(private val innerSet: MutableCollection<T> = HashSet<T>()): MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

interface ClosedShape {
    val name: String
    fun area(): Int
}

class Rectangle(override val name: String, private val width: Int, private val height: Int): ClosedShape {
    override fun area() = width * height
}

class Window(private val bounds: ClosedShape): ClosedShape {
    override val name = bounds.name
    override fun area() = bounds.area()
}

class Window_2(private val bounds: ClosedShape): ClosedShape by bounds