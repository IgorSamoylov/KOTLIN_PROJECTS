class Point(var x: Int, var y: Int) {
    operator fun inc(): Point {
        x++
        y++
        return Point(x, y)
    }

}

fun main() {
    var point = Point(100, 150)
    point++
    println("${point.x}  ${point.y}")

}