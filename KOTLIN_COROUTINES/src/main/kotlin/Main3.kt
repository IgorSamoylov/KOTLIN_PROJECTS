import kotlinx.coroutines.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {

    // #1 OLD STYLE
    val executorService = Executors.newFixedThreadPool(4)
    val lambdaSupplier = {
        println("Runnable Task start! ${Thread.currentThread().id}")
        Thread.sleep(5000)
        println("Runnable Task Complete! ${Thread.currentThread().id}")

        val result = "COMPLETED!"
        result
    }
    executorService.submit(lambdaSupplier)
    executorService.shutdown()

    // #2 USING COMPLETABLE FUTURE
    val completableFuture = CompletableFuture<String>()
    completableFuture.completeAsync(lambdaSupplier)
    println(completableFuture.get())

    // #3 KOTLIN COROUTINE STYLE
    runBlocking {  taskRun() }
}

suspend fun taskRun(): Job {
    val task = coroutineScope {
        launch {
            println("Coroutine start! ${Thread.currentThread().id}")
            delay(3000)
            println("Coroutine end! ${Thread.currentThread().id}")
        }
    }
    return task
}