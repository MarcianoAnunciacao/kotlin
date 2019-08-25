package rsk

fun main(args: Array<String>){
    val text = "With    multiple  \t  whitespace"
    println(replaceMultipleWithSpace(text))
    println(text.replaceMultipleWithSpaceEx())
}

fun replaceMultipleWithSpace(value: String): String {
    var regex = Regex("\\s+")
    return regex.replace(value, " ")
}

fun String.replaceMultipleWithSpaceEx(): String {
    var regex = Regex("\\s+")
    return regex.replace(this, " ")
}