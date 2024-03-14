package assignment1

fun main() {
    println("Nhập tháng (1-12):")
    val month = readLine()?.toIntOrNull() ?: 0

    println("Nhập năm:")
    val year = readLine()?.toIntOrNull() ?: 0

    val daysInMonth = getDaysInMonth(month, year)
    if (daysInMonth != -1) {
        println("Số ngày trong tháng $month năm $year là: $daysInMonth")
    } else {
        println("Tháng không hợp lệ!")
    }
}

fun getDaysInMonth(month: Int, year: Int): Int {
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> {
            if (isLeapYear(year)) 29 else 28
        }
        else -> -1
    }
}

fun isLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}