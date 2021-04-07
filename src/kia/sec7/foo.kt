package kia.sec7

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

data class PointSample(val x: Int, val y: Int)
operator fun PointSample.plus(other: PointSample): PointSample {
    return PointSample(x + other.x, y + other.y)
}