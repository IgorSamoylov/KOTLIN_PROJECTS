
fun main(args: Array<String>) {

    var hello = "Hello KOTlin"
    println(hello)



    while (true) {
        val line = readLine()
        if (line != "") {
            println("$line is my Answer")
        } else break
    }
    val x = 0b00000010 // Запись числа в двоичной системе начинается с 0b
    val y = 0xfff   // Запись числа в 16-ричной системе начинается с 0x

    println(x)
    println(y)

    val uniqueString =
        "А это необычная \"строка\". Хотя бы потому, что часть \"слов\" в ней в \"кавычках\"."
            // Обратный слэш \ "экранирует" служебный символ кавычек

    println (uniqueString)

    val newString = "\u00f7"
        // Символ деления вводится внутри строки в 16-ричной
        // 16-битовой форме и экранируется префиксом \u
    println (newString)


}