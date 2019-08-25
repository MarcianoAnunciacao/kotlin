package rsk

fun main(){
    var marte = Student("Marciano ", " Anunciação ",1)
    println("${marte.id}  ${marte.lastName}  ${marte.firstName}  ${marte.tutor}")
}

abstract class Person (var firstName: String, var lastName: String){

    open fun getName():String = "$firstName $lastName"

    abstract fun getAddress():String
}

class Student(firstName: String, lastName: String, val _id:Int) : Person(firstName, lastName){
    var tutor: String
    var id = _id

    init{
        id = _id
        tutor = ""
    }

    constructor(firstName: String, lastName: String, _id: Int, tutor: String): this(firstName, lastName, _id){
        this.tutor = tutor
    }

    override fun getAddress(): String {
        return ""
    }

    override fun getName(): String{return ""}
}