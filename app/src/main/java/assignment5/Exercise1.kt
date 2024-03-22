package assignment5

import kotlinx.coroutines.*
import java.util.Scanner

suspend fun fibonacci(n: Int): Int = coroutineScope {
    var current = 0
    var next = 1
    for (i in 0 until n) {
        val temp = current + next
        current = next
        next = temp
    }
    current
}

fun main() = runBlocking<Unit> {
    val scanner = Scanner(System.`in`)
    print("Nhập n:")
    val n = scanner.nextInt()
    val result = fibonacci(n)
    println("Số Fibonacci thứ $n là: $result")
}
