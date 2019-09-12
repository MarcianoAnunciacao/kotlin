package com.rsk

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import kotlin.concurrent.thread


fun main(){

    //Com coroutines
    GlobalScope.launch{
        delay(1000)
        println("World")
    }

    print("Hello, ")
    Thread.sleep(1500)

    //Forma tradicional
    thread {
        sleep(1000)
        println("World")
    }

    print("Hello, ")

    Thread.sleep(1500)

}
