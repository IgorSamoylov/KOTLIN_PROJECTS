import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.lang.Exception
import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.HashMap

val fileEntryList = HashMap<File, String>()

fun dirTraversal(file: File) {

    if(file.isDirectory) {
        val fileList: Array<File> = file.listFiles() ?: return
        fileList.forEach { f -> dirTraversal(f) }
        return
    }

    val fileReader = file.bufferedReader()
    val fileEntry = StringBuilder()
    try {
        while (true) {
            fileEntry.append(Char(fileReader.read()))
        }
    } catch (ex: Exception) { }
    fileReader.close()

    fileEntryList[file] = fileEntry.toString()
    //fileEntryList[file] = ""

}

fun main() {
    //val file = File("D:/БЛОКНОТЫ ПРОГРАММИРОВАНИЕ/")
    val scanner = Scanner(System.`in`)
    println("Введите корневую директорию для поиска всех файлов")
    val path = scanner.nextLine()
    val file = File(path)

    dirTraversal(file)
    val i = AtomicInteger(0)
    fileEntryList.forEach { entry ->  println( "${i.incrementAndGet()}  ${entry.key}") }

    while(true) {
        println("Введите строку для поиска во всех найденных файлах")
        val stringToFind = scanner.nextLine()
        if(stringToFind == "") break

        i.set(0)
        fileEntryList
            .filterValues { value -> value.contains(stringToFind, ignoreCase = true) }
            .forEach { entry -> println("${i.incrementAndGet()}  ${entry.key}") }
    }
}