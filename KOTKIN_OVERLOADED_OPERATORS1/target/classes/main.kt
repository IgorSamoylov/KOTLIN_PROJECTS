class Point(var x: Int, var y: Int) {
    operator fun inc(): Point { // ФУНКЦИЯ - ЧЛЕН
        x++
        y++
        return this
    }

}

fun main() {
    var point = Point(100, 150)
    point++
    println("${point.x}  ${point.y}")

    // ФУНКЦИЯ - РАСШИРЕНИЕ(одиночная функция, добавляемая к классу в кач-ве метода)
    operator fun Point.dec(): Point {
        x--
        y--
        return this
    }
    point--
    point--
    println("${point.x}  ${point.y}")

    // ИНФИКСНАЯ ЗАПИСЬ ФУНКЦИИ
    infix fun Int.incrementer(x: Int): Int {
        val y = x + 10
        return y
    }
    println(200 incrementer 100)


    // ЛЯМБДЫ
    val kotlinLambda = {x: Int ->
        val y = x + 1000
        y
    }

    println(kotlinLambda(1000))


    val kotlinLamda1: (Int, Int) -> Int = {x, y -> x * y}

    println(kotlinLamda1(70, 70))

}