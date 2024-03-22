package assignment4

fun <T> swap(array: Array<T>, index1: Int, index2: Int) {
    if (index1 < 0 || index1 >= array.size || index2 < 0 || index2 >= array.size) {
        throw IndexOutOfBoundsException("Invalid index")
    }

    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5)
    println("Mảng ban đầu: ${array.joinToString()}")

    swap(array, 1, 3)
    println("Mảng sau khi hoán đổi: ${array.joinToString()}")
}