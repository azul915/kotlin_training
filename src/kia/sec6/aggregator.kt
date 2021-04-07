package kia.sec6

import java.io.BufferedReader
import java.io.StringReader

fun sec6Output(): Any {
//    return invokeStrLenSafe()
//    return invokePrintAllCaps()
//    return invokeManagerName()
//    return invokeCountryName()
//    return invokeStrLenSafeSample()
//    return invokePrintShippingLabel()
//    return invokePersonSample()
//    return invokeIgnoreNulls()
//    return invokeSendToEmail()
//    return bar()
//    return invokeNullOk()
//    return invokePrintHashCode()
//    return invokeFoo()
//    return invokePiyo()
//    return abc()
//    return invokeAddValidNumbers()
//    return invokeAddValidNumbersSample()
//    return invokeCopyElements()
//    return invokeGreet()
    return invokeGreetMutableList()
}

fun invokeStrLenSafe() {
    val x: String? = null
    strLenSafe(x).also { println(it) }

    strLenSafe("abc").also { println(it) }
}

fun invokePrintAllCaps() {
    printAllCaps("abc")
    printAllCaps(null)
}

fun invokeManagerName() {
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

}

fun invokeCountryName() {
    val person = Person("Dimitry", null)
    println(person.countryName())
    person.countryNameSample().also { println(it) }
}

fun invokeStrLenSafeSample() {
    strLenSafeSample("abc").also { println(it) }
    strLenSafeSample(null).also { println(it) }
}

fun invokePrintShippingLabel() {
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dimitry", jetbrains)

    printShippingLabel(person)
    printShippingLabel(Person("Alexey", null))
}

fun invokePersonSample() {
    val p1 = PersonSample("Dmitry", "Jemerov")
    val p2 = PersonSample("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))

}

fun invokeIgnoreNulls() {
    ignoreNulls(null)
}

fun invokeSendToEmail() {
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}

fun invokeNullOk() {
    verifyUserInput("sample-user")
    verifyUserInput(" ")
    verifyUserInput(null)
}

fun invokePrintHashCode() {
    printHashCode("test")
    printHashCodeWithAny("foo")
}

fun invokeFoo() {
    showProgresss(146)
    PersonFoo("Foo", 21).isOlderThan(PersonFoo("Hoge", 23)).also { println(it) }
    PersonFoo("Piyo", 53).isOlderThan(PersonFoo("Fuga")).also { println(it) }
}

fun invokePiyo() {
    piyo()
}

fun invokeABC() {
    abc()
}

fun invokeFail() {
    fail("Error occured")
}

fun invokeAddValidNumbers() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    println(numbers)
    addValidNumbers(numbers)
}

fun invokeAddValidNumbersSample() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    println(numbers)
    addValidNumbersSample(numbers)
}

fun invokeCopyElements() {
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
    println(target)
}

fun invokeGreetArray() {
    val array: Array<String> = arrayOf("おはようございます", "こんにちは", "こんばんは")
    greetArray(array)
    println(array[0])
}

fun invokeGreetMutableList() {
    val list = mutableListOf<String>("foo", "bar")
    greetMutableList(list)
    println(list)
}
