package assignment1


    fun main() {
        println("Nhập chuỗi:")
        val inputString = readLine() ?: ""

        val words = inputString.split("\\s+".toRegex()).toMutableList()
        var count = 0
        words[0] =  words[0].capitalize()
        for (i in words.indices) {
            if (words[i].isNotEmpty()) {
                count++
                if (i > 0 && words[i - 1].last() in setOf('.', '!', '?')) {
                    words[i] = words[i].capitalize()
                }
            }
        }
        println("Số từ trong chuỗi là: $count")
        println("Chuỗi sau khi viết hoa chữ cái đầu tiên của từ nếu nó bắt đầu cho một câu: ${words.joinToString(" ")}")
    }
