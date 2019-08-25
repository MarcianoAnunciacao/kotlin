package rsk

import java.util.*

class Meeting{
    var Title: String = ""
    var When : Date = Date()
    var Who =  mutableListOf<String>()

    fun create(){}
}

fun main(){
    val m = Meeting()
    m.Title = "Board Meeting"
    m.When = Date(2017, 1, 1)
    m.Who.add("Marciano")

    with(m){
        m.Title = "Daily Meeting"
        m.When = Date(2017, 1, 1)
        m.Who.add("Marte")
    }

    m.apply {
        m.Title = "Regular Meeting"
        m.When = Date(2017, 1, 1)
        m.Who.add("José")
    }.create()
}
