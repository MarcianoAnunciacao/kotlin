package coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {
    val jobs = arrayListOf<Job>()
    jobs += GlobalScope.launch( Dispatchers.Unconfined /*coroutinesContext*/) {
        //context of the parent, runBlocking coroutine
        println("'coroutineContext': I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("'coroutineContext': After delay in thread ${Thread.currentThread().name}")
    }
    jobs.forEach{it.join()}

    val job = GlobalScope.launch {
        println("isActive? ${coroutineContext[Job]!!.isActive}")
    }

    job.join()
}