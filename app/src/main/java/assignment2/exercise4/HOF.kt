package assignment2.exercise4

import kotlin.math.absoluteValue

fun main() {
    getInputAndCalculateSumOfDigits(::calculateSumOfDigits)
}

fun getInputAndCalculateSumOfDigits(calculateSum: (Int) -> Int) {
    print("Nhập vào một số tự nhiên: ")
    val input = readLine()
    if (input != null) {
        try {
            val number = input.toInt()
            if (number < 0) {
                println("Vui lòng nhập một số tự nhiên.")
                return
            }
            val sum = calculateSum(number)
            println("Tổng các chữ số của $number là: $sum")
        } catch (e: NumberFormatException) {
            println("Vui lòng nhập một số tự nhiên hợp lệ.")
        }
    }
}

fun calculateSumOfDigits(number: Int): Int {
    return number.absoluteValue.toString().map { it.toString().toInt() }.sum()
}
