package com.rsk.kotlin

import com.rsk.java.Meeting
import com.rsk.java.Organizer

fun main(){
    var people : List<Person?>? = null

    var mutablePerson: MutableList<Person?>? = null

    people = listOf(Person(23), Person(24), null)

    mutablePerson?.add(null)

    for(person: Person? in people.filterNotNull()){
        println(person?.age)
    }
}

class Person(val age: Int) : Organizer{
    override fun processMeetings(meetings: MutableList<Meeting>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}