package assignment2.exercise3

fun main() {
    getInputAndCalculateSum(::sumOfNumbers)
}

fun getInputAndCalculateSum(sumFunction: (Int) -> Int) {
    print("Nhập vào một số nguyên: ")
    val input = readLine()
    if (input != null) {
        try {
            val number = input.toInt()
            val sum = sumFunction(number)
            println("Tổng các số tự nhiên nhỏ hơn hoặc bằng $number là: $sum")
        } catch (e: NumberFormatException) {
            println("Vui lòng nhập một số nguyên hợp lệ.")
        }
    }
}

fun sumOfNumbers(number: Int): Int {
    return if (number <= 0) {
        0
    } else {
        number + sumOfNumbers(number - 1)
    }
}
