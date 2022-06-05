
import java.math.BigInteger
import kotlinx.coroutines.*


val resultArray = ArrayList<BigInteger>(30)

fun factorial(n: Int) {
    var result = BigInteger("1") // Параметр инициализации класса BigInteger - строка
    for(i in 1..n) result *= BigInteger(i.toString())  // Kotlin имеет перегруженные операторы для класса BigInteger
    resultArray.add(result)
}


fun main() {
    val dataArray = Array<Int>(30) {indx -> (indx + 1) * 10}

    //Здесь блокируемся в основном потоке и запускаем корутины, ожидая их выполнения
    runBlocking {
        dataArray.forEach { element ->
            launch {
                factorial(element)
            }
        }
    }


    // Это неблокирующий запуск корутины
    run { factorial(777) }

    for(i in dataArray.indices) { // Данная переменная Kotlin Array возвращает все существующие индексы в нём
        println("Факториал ${dataArray[i]}! = ${resultArray[i]}")
    }

    Thread.sleep(5000L) // Ожидаем 5 сек для выполнения неблокированной корутины
    println("Факториал 777 =" + resultArray.last()) // Метод ArrayList.last() возвращает последний элемент списка
    //resultArray.forEach { item -> println(item) }

}