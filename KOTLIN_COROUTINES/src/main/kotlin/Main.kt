import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*

fun main() {
    creating_10k_Thread()
    creating_100k_Coroutines()
}

fun creating_10k_Thread() {
    val time = measureTimeMillis {
        for(i in 1..10000) {
            Thread { Thread.sleep(1) }.run()
        }
    }
    println(time)
}

fun creating_100k_Coroutines(){
    val time = measureTimeMillis {
        runBlocking {
            for(i in 1..100000) {
                launch {
                    delay(10000L)
                }
            }
        }
    }
    println(time)
}

