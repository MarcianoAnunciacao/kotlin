package com.rsk

val action = {println("Hello World")}
val calc : (Int, Int) -> Int = {x, y -> x * y}

fun main(){
    doSomething(action)

}

fun doSomething(func: () -> Unit){
    func()
}