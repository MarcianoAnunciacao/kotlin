package coroutine

import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = GlobalScope.launch {
        val result = async(start = CoroutineStart.LAZY){ doWorkLazy()}
        println("Result is ${result.await()}")
    }

    job.join()

}

suspend fun doWorkLazy(): Int{
    log("Be Lazy")
    delay(200)
    log("Lazy Done")
    return 42
}

fun log(msg: String){
    println("$msg in ${Thread.currentThread().name}")
}