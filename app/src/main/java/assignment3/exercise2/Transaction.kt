package assignment3.exercise2

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

open class Transaction(
    var transactionId: String,
    var transactionDate: String,
    var unitPrice: Double,
    var area: Double
) {
    constructor() : this("", "", 0.0, 0.0)

    open fun addTransaction() {
        val scanner = Scanner(System.`in`)
        println("Enter transaction ID:")
        transactionId = scanner.nextLine()

        var isValidDate = false
        while (!isValidDate) {
            println("Enter transaction date (dd/MM/yyyy):")
            val dateInput = scanner.nextLine()
            if (isValidDate(dateInput)) {
                transactionDate = dateInput
                isValidDate = true
            } else {
                println("Invalid date format. Please enter again.")
            }
        }

        println("Enter unit price:")
        unitPrice = scanner.nextDouble()

        println("Enter area:")
        area = scanner.nextDouble()
    }

    open fun displayTransaction() {
        println("Transaction ID: $transactionId")
        println("Transaction Date: $transactionDate")
        println("Unit Price: $unitPrice")
        println("Area: $area")
    }

    open fun calculatePrice(): Double {
        return 0.0
    }

    private fun isValidDate(date: String): Boolean {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        dateFormat.isLenient = false

        return try {
            dateFormat.parse(date)
            true
        } catch (e: ParseException) {
            false
        }
    }

    open fun getMonthFromDate(): Int {
        val parts = transactionDate.split("/")
        return if (parts.size == 3) {
            parts[1].toInt()
        } else {
            0
        }
    }
}
