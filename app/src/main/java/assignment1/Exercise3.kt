package assignment1

fun main() {
    var input: String
    var n: Int
    do {
        println("Nhập vào một số nguyên n:")
        input = readLine() ?: ""
        n = input.toIntOrNull() ?: -1

        if (n == -1) {
            println("Đây không phải là số nguyên.")
        }
    } while (n == -1)

    val arr = IntArray(n)
    for(  i in 0 until arr.size){
        println("Nhập vào phần tử thứ ${i}:")
        do {
            input = readLine() ?: ""
            n = input.toIntOrNull() ?: -1
            if (n == -1)  println("Đây không phải là số nguyên.") else arr[i]=n
        } while (n == -1)
    }
    arr.sort()
    println("Mảng đã nhập và được sắp xếp là: ${arr.joinToString()}")
}