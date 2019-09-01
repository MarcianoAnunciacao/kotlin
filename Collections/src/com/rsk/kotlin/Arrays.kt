package com.rsk.kotlin

fun main(){
    val items = IntArray(2)
    items[0] = 1
    items[1] = 2

    val numbers = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    numbers.forEachIndexed{index, element ->
        println("$index is : $element")
    }
}