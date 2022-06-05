
fun main(args: Array<String>) {


    val lambda1 = {x: Int ->
        val n = x * x
        n
    }

    val arr = IntArray(10) { i -> i}
    arr.map { x -> lambda1(x) }.forEach { x -> println(x) }



    val items = listOf(1, 2, 3, 4, 5)

    // Лямбда - это блок кода, заключенный в фигурные скобки.
    items.fold(0) {
        // Если у лямбды есть параметры, то они указываются перед знаком '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // Последнее выражение в лямбде считается возвращаемым значением:
        result
    }

    // Типы параметров в лямбде необязательны, если они могут быть выведены:
    val joinedToString = items.fold("Elements:") { acc, i -> acc + " " + i }

    // Ссылки на функции также могут использоваться для вызовов функций высшего порядка:
    val product = items.fold(1, Int::times)

    println("joinedToString = $joinedToString")
    println("product = $product")

    // Функцию можно передать в качестве объекта в массив, используя ::имя_функции
    val arrayOfFunctions = Array<()->Int>(5){::testElem}
    arrayOfFunctions[1] = ::testElem
    println(arrayOfFunctions[1]()) // Так можно вызвать функцию в массиве, аналогично Питону
}


fun testElem(): Int {
    return 777
}

