package kia.sec3

fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((i, e) in collection.withIndex()) {
        if (i > 0) result.append(separator)
        result.append(e)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> joinToStringHasDefaultArgs(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for((i, e) in collection.withIndex()) {
        if (i > 0) result.append(separator)
        result.append(e)
    }
    result.append(postfix)
    return result.toString()
}
