package kia.sec7

fun sec7Output(): Any {
//    return invokePlus()
    return invokePointSamplePlus()
}

fun invokePlus() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
}

fun invokePointSamplePlus() {
    val p1 = PointSample(10, 20)
    val p2 = PointSample(30, 40)
    println(p1 + p2)
}