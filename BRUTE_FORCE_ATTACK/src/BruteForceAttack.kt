import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder

val alphabet = "0123456789abcdefhgiklmnjrstopuqwxyz"

fun makeRequest(password: String) {

}

/*fun passwordGenerator(passLength: Int): String {
    for(i in 0 until alphabet.length) {
        val password = passwordGenerator(passLength - 1) + alphabet[i]
    }

}*/

fun main() {

    val base = alphabet.length
    var password = ""
    var baseStr = ""
/*
    var count: Long = 0
    for(i in 0 until base) {
        for(k in 0 until base) {
            for(l in 0 until base) {
                for(m in 0 until base) {
                    val chars = charArrayOf(alphabet[i], alphabet[k], alphabet[l], alphabet[m])
                    password = chars.concatToString()
                    println(password)
                }
            }
        }
    }
*/
    var n = 0
    var charArray = Array<Char?>(4) {null}
    val position: Int = 0
    while (n < 1500625) {

        val letter = n % base

        if(n / base)

        charArray[position] = alphabet[letter]
        password = charArray.joinToString()
        println(password)
        n++
    }


}