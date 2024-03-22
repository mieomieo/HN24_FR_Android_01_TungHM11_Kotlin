package assignment5


import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun sumOfIntegersUpTo(n: Int): Int {
    return (0..n).sum()
}

fun integerSumFlow(): Flow<Int> = flow {
    for (i in 0..10) {
        emit(sumOfIntegersUpTo(i))
        delay(500)
    }
}

fun main() = runBlocking {
    integerSumFlow().collect { sum ->
        println("Result: $sum")
    }
}
