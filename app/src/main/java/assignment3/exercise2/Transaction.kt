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

        var isValidDate: Boolean
        do {
            println("Enter transaction date (dd/MM/yyyy):")
            val dateInput = scanner.nextLine()
            isValidDate = isValidDate(dateInput)
            if (isValidDate) {
                transactionDate = dateInput
            } else {
                println("Invalid date format. Please enter again.")
            }
        } while (!isValidDate)

        do {
            println("Enter unit price:")
            if (scanner.hasNextDouble()) {
                unitPrice = scanner.nextDouble()
                break
            } else {
                println("Invalid input. Please enter a valid number.")
                scanner.next()
            }
        } while (true)

        do {
            println("Enter area:")
            if (scanner.hasNextDouble()) {
                area = scanner.nextDouble()
                break
            } else {
                println("Invalid input. Please enter a valid number.")
                scanner.next()
            }
        } while (true)
    }


    open fun displayTransaction() {
        val transactionIdWidth = 14
        val transactionDateWidth = 16
        val unitPriceWidth = 17
        val areaWidth = 10

        println("-----------------------------------------------------------------------")
        println("| Transaction ID | Transaction Date | Unit Price        | Area        |")
        println("-----------------------------------------------------------------------")
        println("| ${transactionId.padEnd(transactionIdWidth)} | ${transactionDate.padEnd(transactionDateWidth)} | ${unitPrice.toString().padEnd(unitPriceWidth)} | ${area.toString().padEnd(areaWidth)} |")
        println("-----------------------------------------------------------------------")
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
