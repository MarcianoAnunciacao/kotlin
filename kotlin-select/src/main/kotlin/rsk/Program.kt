package rsk

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import java.lang.Exception

fun CoroutineScope.producer1() : ReceiveChannel<String> = produce{
        send("from producer 1 ")
}

fun CoroutineScope.producer2() : ReceiveChannel<String> = produce{
    send("from producer 1 ")
}

@InternalCoroutinesApi
suspend fun selector(message1: ReceiveChannel<String>, message2: ReceiveChannel<String>) : String =
    select<String> {
        message1.onReceiveOrClosed{value -> value.toString() ?: "Channel 1 is closed"}
        message2.onReceiveOrClosed{value -> value.toString() ?: "Channel 2 is closed"}
    }


@InternalCoroutinesApi
fun main() = runBlocking{
    val m1 = producer1()
    val m2 = producer2()

    repeat(15) {
        try {
            println(selector(m1, m2))
        }catch (e : Exception){
            println("Channel is closed")
        }

    }
}