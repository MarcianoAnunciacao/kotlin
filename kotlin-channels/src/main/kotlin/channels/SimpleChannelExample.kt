package channels

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()

    val job = GlobalScope.launch {
        for(x in 1..5){
            println("send $x")
            channel.send(x)
        }
    }

    println("receive: ${channel.receive()}")

    repeat(4){
        println("receive: ${channel.receive()}")
    }

    job.join()
}