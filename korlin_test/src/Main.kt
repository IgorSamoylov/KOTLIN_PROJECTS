

class FirstClass<T>(welcomeMessage: String)  {
    init {
        println(welcomeMessage)
    }
    constructor(welcomeMessage: String, array: Array<Array<T>>) : this(welcomeMessage) {
        for (a in array) {
            for (name in a) {
                println("$welcomeMessage $name")
            }
        }

        val innerArray: Array<String> = array[1]
        if ("Oliver" in array[1].asIterable().toString()) {
            println("Подмассив 1 содержит Oliver!")
        }
    }
}



fun firstFunction(message: String) {
    println(message)
}

fun main(){
    firstFunction("Hello Igor")
    val myClass = FirstClass<String>("Hello Barsik")
    val namesArray =  arrayOf(arrayOf("Pushok", "Snejok", "Vasilek"),
        arrayOf("Lutik", "Oliver", "Murlik"),
        arrayOf("Leo", "Tiger", "Murzik")
    )
    val myClass2 = FirstClass<String>("Hello", namesArray)
}