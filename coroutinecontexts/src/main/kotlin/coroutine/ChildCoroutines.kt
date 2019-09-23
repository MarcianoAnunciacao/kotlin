package coroutine

import jdk.nashorn.internal.objects.Global
import kotlinx.coroutines.*

fun main() = runBlocking {
    val outer = GlobalScope.launch {
        GlobalScope.launch(coroutineContext) {
            repeat(1000) {
                print(".")
                delay(1)
            }
        }
    }

    delay(200)
    outer.cancelChildren()
    println()
    println("Finished")
}