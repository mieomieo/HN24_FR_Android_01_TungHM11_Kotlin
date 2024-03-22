fun <T> countElementsWithProperty(collection: Collection<T>, propertyChecker: (T) -> Boolean): Int {
    var count = 0
    for (element in collection) {
        if (propertyChecker(element)) {
            count++
        }
    }
    return count
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val countOddNumbers = countElementsWithProperty(numbers) { it % 2 != 0 }
    println("Số lượng số lẻ trong tập hợp là: $countOddNumbers")

    val countPrimeNumbers = countElementsWithProperty(numbers) { isPrime(it) }
    println("Số lượng số nguyên tố trong tập hợp là: $countPrimeNumbers")
}

fun isPrime(number: Int): Boolean {
    if (number <= 1) {
        return false
    }
    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}
