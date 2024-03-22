package assignment3.exercise2

import java.util.Scanner

class LandTransaction(
    var landType: String
) : Transaction() {
    constructor() : this("")

    override fun addTransaction() {
        super.addTransaction()
        val scanner = Scanner(System.`in`)

        do {
            println("Enter land type (A, B, C):")
            landType = scanner.nextLine().toUpperCase()
        } while (landType !in listOf("A", "B", "C"))
    }
    override fun displayTransaction() {
        super.displayTransaction()
        println("Land Type: $landType")
    }

    override fun calculatePrice(): Double {
        return when (landType.toUpperCase()) {
            "A" -> area * unitPrice * 1.5 * 1.1
            "B" -> area * unitPrice * 1.1
            "C" -> area * unitPrice
            else -> 0.0
        }
    }
}