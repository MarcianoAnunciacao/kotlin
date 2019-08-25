@file:JvmName("DisplayFunctions")

package rsk

fun main(){
    log(message = "Hello World : ", logLevel = 2)
}

fun display(message: String) : Boolean{
    println(message)
    return true
}

@JvmOverloads
fun log(message: String, logLevel: Int = 1){
    println(message + logLevel)
}
