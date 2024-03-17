package assignment2.exercise3

val sumOfNumbers: (Int) -> Pair<String, Int> = { n ->
    fun sumHelper(n: Int, acc: String, sum: Int): Pair<String, Int> {
        return if (n <= 0) {
            Pair(acc, sum)
        } else {
            sumHelper(n - 1, if (acc.isEmpty()) "$n" else "$n+$acc", sum + n)
        }
    }
    sumHelper(n, "", 0)
}

fun getInputAndCalculateSum() {
    print("Nhập vào một số nguyên dương: ")
    val input = readLine()
    if (input != null) {
        try {
            val number = input.toInt()
            if (number < 0) {
                println("Vui lòng nhập số nguyên dương.")
                return
            }
            val (sequence, result) = sumOfNumbers(number)
            println("Các số tự nhiên nhỏ hơn hoặc bằng $number là: $sequence = $result")
        } catch (e: NumberFormatException) {
            println("Vui lòng nhập một số nguyên dương hợp lệ.")
        }
    }
}

fun main() {
    getInputAndCalculateSum()
}
