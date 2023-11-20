import java.lang.NumberFormatException

fun main() {
    println(" please enter any digits maximum 6 digits :")
    val num = readLine()
    try{
        val num = num?.toInt()
        if (num!=null){
            if (num in 0..999999) {
                val output = DigitComverter(num)
                println("The corresponding words for $num is : $output")
            }
                else {
                println("Please enter the valid number correspond to the given max Length")
            }}
            else
            println("invalid input .please provide correct digit form")
    }
    catch (e: NumberFormatException){
        println("invalid input. Please enter valid integer")
    }

}

fun DigitComverter(number: Int): String {
    val units = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = arrayOf("eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    val words = mutableListOf<String>()

    val millions = number / 1000000
    val remainderMillions = number % 1000000
    val thousands = remainderMillions / 1000
    val remainderThousands = remainderMillions % 1000
    val unitsDigit = remainderThousands % 10
    val tensDigit = (remainderThousands % 100) / 10
    val hundredsDigit = remainderThousands / 100

    if (millions > 0) {
        words.add("${units[millions]} million")
    }

    if (thousands > 0) {
        words.add("${DigitComverter(thousands)} thousand")
    }

    if (hundredsDigit > 0) {
        words.add("${units[hundredsDigit]} hundred")
    }

    if (tensDigit == 1 && unitsDigit > 0) {
        words.add(teens[unitsDigit - 1])
    } else if (tensDigit > 0) {
        words.add(tens[tensDigit])
        if (unitsDigit > 0) {
            words.add(units[unitsDigit])
        }
    } else if (unitsDigit > 0) {
        words.add(units[unitsDigit])
    }

    return words.joinToString(" ")
}
