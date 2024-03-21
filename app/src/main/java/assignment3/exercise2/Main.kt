package assignment3.exercise2

import java.util.Calendar
import java.util.Scanner

fun main() {
    val landTransactions = mutableListOf<LandTransaction>()
    val houseTransactions = mutableListOf<HouseTransaction>()

    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        println("Menu:")
        println("1. Add Land Transaction")
        println("2. Add House Transaction")
        println("3. Display Transactions")
        println("4. Calculate Total Quantity for Each Type")
        println("5. Calculate Average Price of Land Transactions")
        println("6. Display Transactions of Previous Month in Current Year")
        println("0. Exit")
        print("Enter your choice: ")

        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                val landTransaction = LandTransaction()
                landTransaction.addTransaction()
                landTransactions.add(landTransaction)
            }
            2 -> {
                val houseTransaction = HouseTransaction()
                houseTransaction.addTransaction()
                houseTransactions.add(houseTransaction)
            }
            3 -> {
                displayTransactions(landTransactions, houseTransactions)
            }
            4 -> {
                calculateTotalQuantity(landTransactions, houseTransactions)
            }
            5 -> {
                calculateAveragePrice(landTransactions)
            }
            6 -> {
                displayTransactionsOfPreviousMonth(landTransactions, houseTransactions)
            }
            0 -> {
                println("Exiting...")
            }
            else -> {
                println("Invalid choice!")
            }
        }
    } while (choice != 0)
}

fun displayTransactions(
    landTransactions: MutableList<LandTransaction>,
    houseTransactions: MutableList<HouseTransaction>
) {
    println("Land Transactions:")
    landTransactions.forEach { it.displayTransaction() }
    println("House Transactions:")
    houseTransactions.forEach { it.displayTransaction() }
}
fun calculateTotalQuantity(
    landTransactions: MutableList<LandTransaction>,
    houseTransactions: MutableList<HouseTransaction>
) {
    val landTypeCount = landTransactions.groupingBy { it.landType }.eachCount()
    println("Total Quantity of Land Transactions by Type:")
    landTypeCount.forEach { (type, count) ->
        println("$type: $count")
    }

    val houseTypeCount = houseTransactions.groupingBy { it.houseType }.eachCount()
    println("Total Quantity of House Transactions by Type:")
    houseTypeCount.forEach { (type, count) ->
        println("$type: $count")
    }
}
fun calculateAveragePrice(landTransactions: MutableList<LandTransaction>) {
    if (landTransactions.isEmpty()) {
        println("No land transactions.")
        return
    }

    var totalPrice = 0.0
    for (transaction in landTransactions) {
        totalPrice += transaction.calculatePrice()
    }
    val averagePrice = totalPrice / landTransactions.size
    println("Average Price of Land Transactions: $averagePrice")
}
fun displayTransactionsOfPreviousMonth(
    landTransactions: MutableList<LandTransaction>,
    houseTransactions: MutableList<HouseTransaction>
) {
    val currentDate = Calendar.getInstance()
    val currentYear = currentDate.get(Calendar.YEAR)
    val currentMonth = currentDate.get(Calendar.MONTH) + 1

    println("Transactions of Previous Month in Current Year:")
    landTransactions.filter { it.getMonthFromDate() == currentMonth && it.transactionDate.contains("$currentYear") }
        .forEach { it.displayTransaction() }
    houseTransactions.filter { it.getMonthFromDate() == currentMonth && it.transactionDate.contains("$currentYear") }
        .forEach { it.displayTransaction() }
}