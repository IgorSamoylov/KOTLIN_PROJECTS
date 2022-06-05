import java.math.BigInteger
import java.util.concurrent.CopyOnWriteArrayList

val resultThreadSafeArray = CopyOnWriteArrayList<BigInteger>()

fun factorial2(n: Int) {
    var result = BigInteger("1")
    for(i in 1..n) result *= BigInteger(i.toString())
    resultThreadSafeArray.add(result)
}



fun main() {
    val dataArray = Array<Int>(30) { indx -> (indx + 1) * 10 }

    // А это классический запуск потоков путём создания объекта класса Thread, передачи ему Runnable и вызова
    // метода .start()
    for (elem in dataArray) {
        Thread { factorial2(elem) }.start()
    }

    // Луп ожидания, когда resultThreadSafeArray наполнится
    while (resultThreadSafeArray.size < dataArray.size) {
        Thread.sleep(10)
    }

    for(i in dataArray.indices) {
        println("Факториал ${dataArray[i]}! = ${resultThreadSafeArray[i]}")
    }
}