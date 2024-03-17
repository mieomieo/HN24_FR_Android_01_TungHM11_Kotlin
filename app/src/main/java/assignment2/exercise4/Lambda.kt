package assignment2.exercise4

import kotlin.math.absoluteValue

fun main() {
    print("Nhập vào một số tự nhiên: ")
    val input = readLine()
    if (input != null) {
        try {
            val number = input.toInt()
            if (number < 0) {
                println("Vui lòng nhập một số tự nhiên.")
                return
            }
            val sum = sumOfDigits(number)
            println("Tổng các chữ số của $number là: $sum")
        } catch (e: NumberFormatException) {
            println("Vui lòng nhập một số tự nhiên hợp lệ.")
        }
    }
}

val sumOfDigits: (Int) -> Int = { num ->
    num.absoluteValue.toString().map { it.toString().toInt() }.sum()
}
