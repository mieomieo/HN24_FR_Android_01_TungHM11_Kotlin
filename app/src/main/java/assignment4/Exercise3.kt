package assignment4

fun <T : Comparable<T>> findMaxInRange(list: List<T>, begin: Int, end: Int): T {
    if (begin < 0 || end > list.size || begin >= end) {
        throw IllegalArgumentException("Invalid range")
    }

    var maxElement = list[begin]
    for (i in begin + 1 until end) {
        if (list[i] > maxElement) {
            maxElement = list[i]
        }
    }
    return maxElement
}

fun main() {
    val numbers = listOf(5, 3, 9, 2, 8, 4, 7, 1, 6)

    val maxInRange = findMaxInRange(numbers, 2, 7)
    println("Phần tử lớn nhất là: $maxInRange")
}
