package assignment4.exercise5

// MyKotlinFunctions.kt
fun add(num1: Long, num2: Long): Long {
    return num1 + num2
}

fun subtract(num1: Long, num2: Long): Long {
    return num1 - num2
}

fun multiply(num1: Long, num2: Long): Long {
    return num1 * num2
}

fun divide(num1: Long, num2: Long): Long {
    require(num2 != 0L) { "Cannot divide by zero" }
    return num1 / num2
}