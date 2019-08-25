import java.lang.NumberFormatException
import java.util.*

fun main(args: Array<String>){
    println("Hello World")

    var myValues = 1..10

    //Loops
    for(i in 1..20){

    }

    for(i in 10 downTo 1 step 2){
        println(i)
    }

    for(i in 10 until 10){
        println(i)
    }

    var ages = TreeMap<String, Int>()
    ages ["Kevin"] = 55
    ages ["Sam"] = 24
    ages ["Alex"] = 24
    ages ["Harry"] = 26

    for((name, age) in ages){
        println("$name is $age")
    }

    val q:Question? = Question()

    var numbers = listOf(1,2,3,4,5,6,7,8,9,10)
    for((index, element)in numbers.withIndex()){
        println("$element at $index")
    }

//    q = Question()

    //Nesse caso a interrogação quer dizer que se q não for nulo proceda com a execução do código sem causar um NullPointerException
    q?.Answer = "42"
    //q.Question = ""

    q?.display()

    println("The answer is ${q?.Answer}")

    var message = if(q?.Answer == q?.CorrectAnswer){
        "Correct!!!"
    }else{
        "Try Again"
    }

    println(message)

    q?.printResult()

    val number:Int? = try{
        Integer.parseInt(q?.Answer)
    }catch (e:NumberFormatException){
        null
    }

    println(" Number is $number")
}

class Question{

    var Answer: String? =null
    val CorrectAnswer = "42"
    val Question: String = "What is the answer to life, the universe and everything?"

    fun display(){
        println("You Said $Answer")
    }

    fun printResult(){
        when (Answer) {
            CorrectAnswer -> print("You were correct")
            else -> print("Try Again")
        }
    }

}
