import java.math.BigInteger

fun main() {
    val n: Long = Int.MAX_VALUE.toLong()
    val nn: Long = (n * n).toLong()
    println(nn)

    //while (true) {
    //    n++
    //    if (n % 100000 == 0) println(n)
    //}

    println(factorial(2500))



}

fun factorial(n: Long): BigInteger{
    var bigInteger = BigInteger("1")
    for(i: Long in 1..n) {
        bigInteger = bigInteger.multiply(BigInteger.valueOf(i))
    }
    return bigInteger
}