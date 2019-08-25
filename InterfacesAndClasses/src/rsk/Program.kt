package rsk

fun main(){
    var marte = StudentData(1, "Marciano")
    var marciano = StudentData(1, "Marciano Anunciação")

    println(marte)

    if (marte == marciano){
        println("Equals")
    }else{
        println("Not Equal")
    }

    var newMarte = marte.copy(name = "Marcius")

    println(newMarte)
}

data class StudentData(val id: Int, val name: String){

}