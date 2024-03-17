package assignment2.exercise2
fun findPrimesBetweenNumbersLambda(start: Int, end: Int): List<Int> {
    val primesBetween = mutableListOf<Int>()
    val isPrime: (Int) -> Boolean = { number ->
        if (number <= 1) {
            false
        } else {
            (2..Math.sqrt(number.toDouble()).toInt()).none { number % it == 0 }
        }
    }
    for (num in start + 1 until end) {
        if (isPrime(num)) {
            primesBetween.add(num)
        }
    }
    return primesBetween
}
fun main() {
    print("Nhập số thứ nhất: ")
    val number1 = readLine()?.toInt() ?: 0
    print("Nhập số thứ hai: ")
    val number2 = readLine()?.toInt() ?: 0

    val primesBetween = findPrimesBetweenNumbersLambda(number1, number2)

    if (primesBetween.isEmpty()) {
        println("Không có số nguyên tố nào -3giữa $number1 và $number2.")
    } else {
        println("Các số nguyên tố giữa $number1 và $number2 là:")
        println(primesBetween.joinToString(", "))
    }
}
