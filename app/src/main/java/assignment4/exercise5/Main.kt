package assignment4.exercise5

fun main() {
    val num1: Long = 10
    val num2: Long = 5
    val sum = add(num1, num2)
    val difference = subtract(num1, num2)
    val product = multiply(num1, num2)
    val quotient = divide(num1, num2)

    println("Sum: $sum")
    println("Difference: $difference")
    println("Product: $product")
    println("Quotient: $quotient")
}
