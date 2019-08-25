package rsk

fun main(){
    var marte = Student("Marciano ", " Anunciação ",1)
    println("${marte.id}  ${marte.lastName}  ${marte.firstName}  ${marte.tutor}")
    marte.enrole("Kotlin Intermediate")

    Student.createPostgrad("Marciano")
    Student.createUndergrad("Kevin")
}

class Program{
    companion object{
        @JvmStatic
        fun main() {
            var marte = Student("Marciano ", " Anunciação ", 1)
            println("${marte.id}  ${marte.lastName}  ${marte.firstName}  ${marte.tutor}")
            marte.enrole("Kotlin Intermediate")
        }
    }
}

abstract class Person (var firstName: String, var lastName: String){

    open fun getName():String = "$firstName $lastName"

    abstract fun getAddress():String
}

open class Student(firstName: String, lastName: String, val _id:Int) : Person(firstName, lastName){
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

    fun enrole(courseName : String){
        val course = Courses
            .allCourses.firstOrNull { it.Title == courseName }
    }

    companion object : XmlSerializer<Student>{
        override fun toXml(item: Student) {

        }

        fun createUndergrad(name: String): Undergraduate{
            return Undergraduate(name)
        }

        fun createPostgrad(name: String): PostGraduate{
            return PostGraduate(name)
        }
    }
}

class Undergraduate(firstName: String) : Student(firstName, "", 1){}

class PostGraduate(firstName: String) : Student(firstName, "", 1){}

interface XmlSerializer<T>{
    fun toXml(item: T)
}