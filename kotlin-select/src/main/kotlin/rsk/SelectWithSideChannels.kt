package rsk

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.selects.select

fun CoroutineScope.produceNumbers(side : SendChannel<Int>) : ReceiveChannel<Int> = produce{
    for (num in 1..10){
        delay(100)
        select<Unit>{
            onSend(num){}
            side.onSend(num){}
        }

    }

    println("Done Sending")
}

fun main() = runBlocking{
    val side = Channel<Int>()

    GlobalScope.launch { side.consumeEach { println("side $it") }}

    val producer = produceNumbers(side)

    producer.consumeEach {
        println("$it")
        delay(500)
    }
}