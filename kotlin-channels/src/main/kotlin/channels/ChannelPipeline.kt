package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceNumbersPipe(): ReceiveChannel<Int> = produce{

    var x = 1

    while (true){
        send(x++)
    }

}

fun CoroutineScope.squareNumbers(numbers: ReceiveChannel<Int>) : ReceiveChannel<Int> = produce{
    for(x in numbers) send(x * x)
}

fun main() = runBlocking {
    val producer = produceNumbersPipe()
    val square = squareNumbers(producer)

    for(i in 1..5) println(square.receive())

    println("Main Done")

    square.cancel()
    producer.cancel()
}