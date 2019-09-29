package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceNumbers() : ReceiveChannel<Int> = produce{
        for(x in 1..5){
            println("send $x")
            send(x)
        }
        println("Done ")


}

fun main() = runBlocking {
    val channel = produceNumbers()

    channel.consumeEach {
        println(it)
    }

   for(y in channel){
       println("receive: $y")
   }

    println("Main Done")
}