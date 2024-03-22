package assignment3.exercise2

import java.util.Scanner

class HouseTransaction(
    var houseType: String,
    var address: String
) : Transaction() {
    constructor() : this("", "")

    override fun addTransaction() {
        super.addTransaction()
        val scanner = Scanner(System.`in`)

        do {
            println("Enter house type (Luxury, Premium, Normal):")
            houseType = scanner.nextLine().capitalize()
        } while (houseType !in listOf("Luxury", "Premium", "Normal"))

        do {
            println("Enter address:")
            address = scanner.nextLine()
        } while (address.isBlank())
    }


    override fun displayTransaction() {
        super.displayTransaction()
        println("House Type: $houseType")
        println("Address: $address")
    }

    override fun calculatePrice(): Double {
        return when (houseType.toLowerCase()) {
            "luxury" -> area * unitPrice * 1.1
            "premium" -> area * unitPrice
            "normal" -> area * unitPrice * 0.9
            else -> 0.0
        }
    }
}