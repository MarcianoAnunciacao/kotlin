package actors

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

suspend fun run(context: CoroutineContext, numberOfJobs: Int, count: Int, action: suspend() -> Unit): Long{
    return measureTimeMillis {
        val jobs = List(numberOfJobs){
             GlobalScope.launch(context){
                repeat(count){action()}
            }
        }
        jobs.forEach{it.join()}
    }
}

sealed class CounterMsg
object InitCounter : CounterMsg()
object IncCounter : CounterMsg()
class GetCounter(val response: CompletableDeferred<Int>) : CounterMsg()

fun CoroutineScope.counterActor() = actor<CounterMsg> {
    var counter = 0
    for (msg in channel){
        when(msg){
            is InitCounter -> counter = 0
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
        }
    }
}

fun main() =  runBlocking{
    val jobs = 1000
    val count = 1000

    val counter = counterActor()

    counter.send(InitCounter)

    val time = run(newFixedThreadPoolContext(1, "Actor"), jobs, count){
        counter.send(IncCounter)
    }

    var response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))

    println("Completed ${jobs * count} actions in $time ms")
    println("result is ${response.await()}")

}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")