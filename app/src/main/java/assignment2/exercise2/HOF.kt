package assignment2.exercise2

fun isPrime(number: Int): Boolean {
    if (number <= 1) return false
    if (number <= 3) return true
    if (number % 2 == 0 || number % 3 == 0) return false
    var i = 5
    while (i * i <= number) {
        if (number % i == 0 || number % (i + 2) == 0)
            return false
        i += 6
    }
    return true
}

fun findPrimesBetweenNumbers(start: Int, end: Int, isPrime: (Int) -> Boolean): List<Int> {
    val primesBetween = mutableListOf<Int>()
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

    val primesBetween = findPrimesBetweenNumbers(number1, number2) { isPrime(it) }

    if (primesBetween.isEmpty()) {
        println("Không có số nguyên tố nào giữa $number1 và $number2.")
    } else {
        println("Các số nguyên tố giữa $number1 và $number2 là:")
        println(primesBetween.joinToString(", "))
    }
}
