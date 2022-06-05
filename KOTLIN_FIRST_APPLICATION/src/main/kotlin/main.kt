import java.math.BigInteger
import java.util.concurrent.CountDownLatch

import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val writer = Test("Kotlin Robot", "Excellent")
    writer.writeHello("Игорь")
    val inputArray = arrayOf(5L, 90L, 100L)
    val resultArray = writer.factorial(inputArray)
    resultArray.forEach { bigInteger -> println(bigInteger)}
    
}

class Test constructor(myName: String) {
    private var nameInner: String

    init {
       nameInner = "$myName !"
        createArray(20)
    }

    constructor(myName: String, mySecondName: String) : this(myName) {
        nameInner ="$myName  $mySecondName !"
    }

    fun writeHello(name: String) {
        println("Hello $name, my name is $nameInner")
    }

    fun factorial(numbers: Array<Long>): ArrayList<BigInteger> {

        val resultArray = ArrayList<BigInteger>()
        val countDownLatch = CountDownLatch(numbers.size)

        for(n in numbers) {
            thread(start = true) {
                var i: Long = 1L
                var result = BigInteger.valueOf(1)

                while (i < n + 1) {
                    result = result.multiply(BigInteger.valueOf(i))
                    i++
                }
                resultArray.add(result)

                countDownLatch.countDown()
            }
        }
        countDownLatch.await()
        return resultArray
    }

    private fun createArray(size: Int) {
        val arrayOutput = Array<Int>(size) { index -> index * index }
        for(item in arrayOutput) {
            if (item !in 5..10) println(item)
        }
    }
}

