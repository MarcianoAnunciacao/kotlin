package coroutine

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
    val job = GlobalScope.launch {
        val time = measureTimeMillis {
            val r1:Deferred<Int> = async { doWorkOne() }
            val r2:Deferred<Int> = async { doWorkTwo() }
            println("result: ${r1.await() + r2.await()}")
        }
    }
}

suspend fun doWorkOne(): Int{
    delay(100)
    println("Working 1")
    return Random(System.currentTimeMillis()).nextInt(42)
}

suspend fun doWorkTwo(): Int{
    delay(200)
    println("Working 2")
    return Random(System.currentTimeMillis()).nextInt(42)
}