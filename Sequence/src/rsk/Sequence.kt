package rsk

fun iter(seq:Sequence<String>){
    for (t in seq) println(t)
}

fun main(){
    val meetings = listOf(Meeting(1, "Boarding Meeting"), Meeting(1, "Commitee Meeting"))

    val titles = meetings
        .asSequence()
        .filter {println("filter($it)"); it.tittle.endsWith("C") }
        .map {println("map($it)"); it.tittle }

    iter(titles)

}

class Meeting(val id: Int, val tittle: String) {
    val people = listOf(Person("Sam"), Person("Marciano"))
}

data class Person(val name: String) {

}
