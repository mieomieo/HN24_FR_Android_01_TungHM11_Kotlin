package assignment1

fun main() {
    val result = mutableListOf<Int>()
    for( i in 10 ..  200 ){
        if(i%7==0 && i%5 !=0 )
           result.add(i)
    }
    println(result.joinToString(", "))
}