import kotlinx.coroutines.*

private fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            asyncOperation()       // работает на фоновом потоке
            launch(Dispatchers.Main) {
                completionHandler() // работает на основном потоке
            }
        }
    }
}

private suspend fun asyncOperation() {
    println("Thread is ${Thread.currentThread().name} AsyncOperation")
    println("Started async operation")
    delay(3000)
    println("Completed async operation")
}

private fun completionHandler() {
    println("Thread is ${Thread.currentThread().name} completionHandler")
    println("Running after async opearion")
    println("Async operation completed") //поток интерфейса
}