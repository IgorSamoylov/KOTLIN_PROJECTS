
// Базовый конструктор класса не требует присвоений с this как в Java
// Переменные создаются сразу в области видимости класса с модификатором private
class Test(id: Int, name: String) {
    // Так можно создать публичную переменную класса (по-умолчанию все public)
    val publicId: Int = id
    // Так можно создать приватную переменную класса
    private val privateId: Int = id * 10

    private var surname: String = ""


    // Блок инициализации, выполняемый при создании объекта
    init {
        println("Блок init # 1: Привет! Мой id = $id, моё имя $name")
    }

    // Вспомогательный перегруженный конструктор принимает все аргументы и
    // затем после : вызывает через this() базовый конструктор с базовыми аргуменами!
    // Также перед вызовом вспомогательного конструктора выполняется блок инициализации!
    constructor(id1: Int, name1: String, surname: String) : this(id1, name1) {
        this.surname = surname
        println("Привет! Мой id = $id1, моё имя $name1, моя фамилия $surname")
    }
    // Ещё один вспомогательный конструктор объявляется аналогичным образом
    constructor(id1: Int, name1: String, surname: String, comment: String) : this(id1, name1) {
        println("Привет! Мой id = $id1, моё имя $name1, моя фамилия $surname. $comment")
    }

    // Все блоки инициализации выполняются раньше вспомогательного конструктора и иных методов,
    // но после основного конструктора и могут принимать из него параметры,
    // по сути являясь продолжением основного конструктора
    init {
        println("Блок init # 2: Приватный id = $privateId")
    }

    fun getSurname(): String {
        return surname
    }


}


fun main() {
    val test = Test(1, "Кот Вася")
    println("Функция main: Публичный id = ${test.publicId}")
    val test2 = Test(2, "Кот","Котофеевич")
    Test(3, "Кот","Барсик", " <- очень умный кот")
    println(test2.getSurname())
}

