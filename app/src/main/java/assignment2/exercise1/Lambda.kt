package assignment2.exercise1
fun findPrimePairsLambda(target: Int): List<Pair<Int, Int>> {
    val isPrime: (Int) -> Boolean = { number ->
        if (number <= 1) {
            false
        } else {
            (2..Math.sqrt(number.toDouble()).toInt()).none { number % it == 0 }
        }
    }

    val primePairs = mutableListOf<Pair<Int, Int>>()
    for (i in 2..target / 2) {
        if (isPrime(i) && isPrime(target - i)) {
            primePairs.add(Pair(i, target - i))
        }
    }
    return primePairs
}
fun main() {
    print("Nhập số cần kiểm tra: ")
    val number = readLine()?.toInt() ?: 0
    val primePairs = findPrimePairsLambda(number)
    if (primePairs.isEmpty()) {
        println("$number không phải là tổng của hai số nguyên tố.")
    } else {
        println("$number có thể được biểu diễn bằng các cặp số nguyên tố sau:")
        primePairs.forEach { pair ->
            println("${pair.first} + ${pair.second}")
        }
    }
}
