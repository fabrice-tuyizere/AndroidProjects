import java.lang.NumberFormatException

fun main() {
    println(" please enter any digits maximum 6 digits :")
    val num = readLine()
    try{
        val number = num?.toInt()


    }
    catch (e: NumberFormatException){
        println("invalid input. Please enter valid integer")
    }

}