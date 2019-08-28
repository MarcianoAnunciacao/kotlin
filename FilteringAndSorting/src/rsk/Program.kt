package rsk

fun main(){
    var ints = listOf(1,2,3,4)

    val smallInts = ints.filter { it < 4 }
    val greterThanTree = {v:Int -> v > 3}

    for(i:Int in smallInts) println(i)

    val squareInts = ints.map { it*it }

    for (i: Int in squareInts) println(i)

    val smallSquareInts = ints
                            .filter{it < 5}
                            .map { it*it  }

    for (i: Int in squareInts) println(i)

    val meetings = listOf(Meeting(1, "Boarding Meeting"), Meeting(2, "Comitee Meeting"))

    val titles: List<String> = meetings
        .filter { it -> it.title.startsWith("C") }
        .map { m -> m.title }
    for(t in titles) println(t)

    val largeInts = ints.all (greterThanTree)

    var numberOfLargeInt = ints.count( greterThanTree)

    println(largeInts)

    println(numberOfLargeInt)

    val people: List<Person> = meetings.flatMap (Meeting::people).distinct()
    for (p in people) println(p.name)

}

class Meeting(val id: Int, val title: String){
    val people = listOf(Person("Sam"), Person("Sam"))
}

data class Person(val name: String) {

}
