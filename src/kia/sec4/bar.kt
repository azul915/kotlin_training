package kia.sec4

interface User {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val email: String, override val nickname: String): User

class SubscribingUser(override val email: String): User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FaceBookUser(override val email: String, private val accountId: Int): User {
    override val nickname = getFacebookName(accountId)
    private fun getFacebookName(id: Int): String = "FacebookName"
}
