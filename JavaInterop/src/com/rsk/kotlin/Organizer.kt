package com.rsk.kotlin

import com.rsk.java.Meeting

fun main() {
    val m = Meeting()

    m.addTitle("Title")
    m.addTitle(null)

    val title: String? = m.meetingTitle()

    println(title)
}