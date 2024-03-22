package assignment5

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random

suspend fun randomGenerator(min: Int, max: Int, outputChannel: Channel<Int>) {
    while (true) {
        val randomNumber = Random.nextInt(min, max + 1)
        outputChannel.send(randomNumber)
        delay(1000)
    }
}

fun main() = runBlocking<Unit> {
    val channel1 = Channel<Int>()
    val channel2 = Channel<Int>()

    val job1 = launch { randomGenerator(-100, 0, channel1) }
    val job2 = launch { randomGenerator(0, 100, channel2) }

    var total = 0
    while (true) {
        val value1 = channel1.receive()
        val value2 = channel2.receive()
        total += value1 + value2
        println("Total: $total")

        if (total <= -100 || total >= 100) {
            println("Reached threshold, stopping coroutines.")
            job1.cancel()
            job2.cancel()
            break
        }
    }
}

