package com.rsk

import jdk.nashorn.internal.objects.Global
import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = GlobalScope.launch {
        repeat(1000){
            delay(100)
            print(".")
        }
    }

    delay(2500)

 /*   job.cancel()
    job.join()*/

    job.cancelAndJoin()

    println("done")
}