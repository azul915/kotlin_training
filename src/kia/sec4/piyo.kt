package kia.sec4.piyo

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

data class Client_2(private val name: String , private val postalCode: Int)

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            //
        }
    }
}
