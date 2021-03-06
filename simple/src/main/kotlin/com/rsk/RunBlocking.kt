package com.rsk

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit>{
    GlobalScope.launch {
        delay(1000)
        println("World ")
    }

    print("Hello, ")

    doWork()

 }

suspend fun doWork() {
    delay(1500)
}
