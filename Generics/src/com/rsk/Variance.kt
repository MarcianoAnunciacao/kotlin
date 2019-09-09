package com.rsk

fun main(){
    var financialMeeting = mutableListOf(FinancialMeeting())
    var meetings: AllMeetings<FinancialMeeting> = AllMeetings(financialMeeting)

    attendAllMeetings(meetings)
}

class AllMeetings<out T: Meeting> (val meetings: List<Meeting>){
    val count: Int get() = meetings.count()

    operator fun get(i : Int) = meetings[i]
}

fun attendAllMeetings(meetings: AllMeetings<Meeting>){
    for(i in 0 until meetings.count){
        meetings[i]
    }
}