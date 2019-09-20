package com.rsk

import kotlinx.coroutines.*

fun main() = runBlocking{
    val job = GlobalScope.launch {
        repeat(1000){
            print(".")
            if(!isActive) return@launch
            delay(100)
        }
    }

    delay(2500)

    job.cancelAndJoin()

    println("done")
}