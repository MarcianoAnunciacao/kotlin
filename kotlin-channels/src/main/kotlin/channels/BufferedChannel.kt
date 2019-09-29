package channels

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    val channel = Channel<Int>(4)
    val sender = GlobalScope.launch (coroutineContext){
        //launch sender coroutine
        repeat(10){
            println("Sending $it")
            channel.send(it)
        }
    }

    delay(1000)
    GlobalScope.launch { repeat(10) {println(" -- Receiving ${channel.receive()}")} }
    sender.cancel()
}