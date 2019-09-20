package com.rsk

import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = GlobalScope.launch {
        try {
            repeat(1000) {
                delay(100)
                print(".")
            }
        }catch (ex: CancellationException){
            println()
            println("Cancelled")
        }   finally {
            withContext(NonCancellable){
                println()
                println("In Finally")
            }
        }
    }

    delay(2500)

    job.cancelAndJoin()

    println("done")
}