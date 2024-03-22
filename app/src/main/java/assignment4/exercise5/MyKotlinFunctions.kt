package assignment4.exercise5

fun add(a: Long, b: Long): Long {
    return a + b
}

fun subtract(a: Long, b: Long): Long {
    return a - b
}

fun multiply(a: Long, b: Long): Long {
    return a * b
}

fun divide(a: Long, b: Long): Long {
    require(b != 0L) { "Divisor cannot be zero" }
    return a / b
}