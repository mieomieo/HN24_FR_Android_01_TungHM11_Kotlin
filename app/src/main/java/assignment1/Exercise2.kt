package assignment1


fun main() {
    var input: String
    var number: Int

    do {
        println("Nhập vào một số nguyên có hai chữ số:")
        input = readLine() ?: ""
        number = input.toIntOrNull() ?: -1

        if (input.length != 2 || number !in 10..99) {
            println("Đây không phải là số nguyên có hai chữ số.")
        }
    } while (input.length != 2 || number !in 10..99)
    val bin = Integer.toBinaryString(number)
    println("Số $number ở dạng nhị phân là: $bin")
    val hex = Integer.toHexString(number)
    println("Số $number ở dạng thập lục phân là: $hex")

}