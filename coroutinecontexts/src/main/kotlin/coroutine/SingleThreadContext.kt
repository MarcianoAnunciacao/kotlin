package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    newSingleThreadContext("SingleThreadCOntext").use{ctx ->
        val job = GlobalScope.launch(ctx){
            println("'SingleThreadContext' : I'm working in thread ${Thread.currentThread().name}")
        }

        job.join()
    }
}