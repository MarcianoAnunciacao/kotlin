package channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

suspend fun sendString(channel: Channel<String>, s: String, interval: Long){
    while(true){
        delay(interval)
        channel.send(s)
    }
}

fun main() = runBlocking {
    val channel = Channel<String>()

    GlobalScope.launch(coroutineContext) { sendString(channel, "foo", 200L) }
    GlobalScope.launch(coroutineContext) { sendString(channel, "bar", 500L) }

    repeat(6){
        println(channel.receive())
    }

    coroutineContext.cancelChildren()
}