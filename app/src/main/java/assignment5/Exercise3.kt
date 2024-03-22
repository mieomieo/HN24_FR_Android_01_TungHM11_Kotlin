package assignment5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Exercise3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {
            val channel = Channel<Int>()

            val job1 = launch {
                randomNumberProducer(channel)
            }

            val job2 = launch {
                squareNumberConsumer(channel)
            }

            job1.join()
            job2.join()
        }

        private fun CoroutineScope.randomNumberProducer(channel: SendChannel<Int>) {
            launch {
                while (true) {
                    val randomNumber = (1..20).random()
                    channel.send(randomNumber)
                    delay(2000)
                }
            }
        }

        private fun CoroutineScope.squareNumberConsumer(channel: ReceiveChannel<Int>) {
            launch {
                for (number in channel) {
                    val square = number * number
                    println("Bình phương của $number là: $square")
                    delay(1000)
                }
            }
        }
    }
}