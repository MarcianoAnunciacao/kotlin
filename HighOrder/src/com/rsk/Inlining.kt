package com.rsk

import java.lang.Exception

fun main(){
    val ints = listOf(1,2,3,4,5,6)
    val i = first(ints) { i -> i == 3}

    println(i)
}

inline fun <T> first(items: List<T>, predicate: (T) -> Boolean) : T{
    for(item in items){
        if(predicate(item)) return item
    }

    throw Exception()
}