package com.rsk

fun main(){
    val names = listOf("Marte")

    printType(listOf(1))
}

fun printType(items: List<Any>){
    val stuff = items as List<String>

    stuff.filter{s -> s == ""}
}