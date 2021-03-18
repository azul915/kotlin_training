package kia.sec4.piyo

import java.io.File

class User(private val name: String) {
    var address: String = "unspecified"
        set(specificAddress: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$specificAddress".""".trimIndent())
            field = specificAddress
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

class Client(private val name: String, private val postalCode: Int) {
    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other.name && postalCode == other.postalCode
    }
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}

data class Client_2(private val name: String, private val postalCode: Int)

data class PersonSample(private val sampleField: String)

object Payroll {
    val allEmployees = arrayListOf<PersonSample>()

    fun calculateSalary() {
        for (person in allEmployees) {
            //
        }
    }
}

object CaseInsensitiveFilecomparator: Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator: Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int = o1.name.compareTo(o2.name)
    }
}

class CompanionSampleA {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

class UserSample {
    private val nickname: String

    constructor(email: String) {
        this.nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        this.nickname = getFacebookName(facebookAccountId)
    }

    private fun getFacebookName(id: Int) = "fooFacebookName"
}

// プライマリコンストラクタをpriateに設定する
class FooUser private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = FooUser(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) = FooUser(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int) = "fooFacebookName"
    }
}

class FooPerson(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): Person = Person(jsonText)
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class BarPerson(val name: String) {
    companion object: JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person {
            TODO("Not yet implemented")
        }
    }
}