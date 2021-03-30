package kia.sec5

data class Person(val name: String, val age: Int)

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach { println("$prefix $it") }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

val action = { person: Person, message: String ->
    sendEmail(person, message)
}

val nextAction = ::sendEmail

fun sendEmail(person: Person, message: String) {
    println("send succcueed")
}

fun cp() {
    val createPerson = ::Person
    val p = createPerson("Alice", 29)
    println(p)
}

fun Person.isAdult() = age >= 21

class Book(val title: String, val authors: List<String>)

fun lambdaSandbox() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    val people = listOf<Person>(Person("Alice", 29), Person("Bob", 31))

    people.filter { it.age > 30 }.run { println(this) }
    list.map { it * it }.run { println(this) }
    people.map { it.name }.run { println(this) }
    people.map(Person::name).run { println(this) }

    people.filter { it.age > 30 }.map { it.name }.run { println(this) }

    val maxAge: Int? = people.maxByOrNull { it.age }?.age
    people.filter { it.age == maxAge }.run { println(this) }

    val numbers = mapOf<Int, String>(0 to "zero", 1 to "one")
    numbers.mapValues { it.value.toUpperCase() }.run { println(this) }
    numbers.mapKeys { it.value.toUpperCase() }.run { println(this) }

    val canBeInClub27 = { p: Person -> p.age <= 27 }
    val p = listOf<Person>(Person("Alice", 27), Person("Bob", 31))
    p.all(canBeInClub27).run { println(this) }
    p.any(canBeInClub27).run { println(this) }

    println(!list.all { it == 3 })
    println(list.any { it != 3 })
    p.count(canBeInClub27).run { println(this) }
    p.find(canBeInClub27).run { println(this) }

    var mutablePeople = people.toMutableList()
    mutablePeople.add(Person("Carol", 31))
    mutablePeople.groupBy { it.age }.run { println(this) }

    val li = listOf("a", "ab", "b")
    li.groupBy(String::first).run { println(this) }

    val strings = listOf("abc", "def")
    strings.flatMap { it.toList() }.run { println(this) }

    val books: List<Book> = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
    Book("Mort", listOf("Terry Prachett")),
    Book("GoodOmens", listOf("Terry Prachett", "Neil Gaiman")))
    books.flatMap { it.authors }.toSet().run { println(this) }

    val nums: List<List<Int>> = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    nums.flatten().run { println(this) }

//    people.map(Person::name).filter { it.startsWith("A") }.run { println(this) }
    people.asSequence().map(Person::name).filter { it.startsWith("A") }.toList().run { println(this) }

    listOf(1, 2, 3, 4).asSequence().map { print("map($it) "); it * it }.filter { print("filter($it) "); it % 2 == 0 }.toList()

    listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 }.run { println(this) }
}