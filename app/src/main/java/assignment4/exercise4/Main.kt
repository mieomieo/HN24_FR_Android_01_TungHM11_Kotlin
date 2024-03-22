package assignment4.exercise4


import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.isAccessible

fun main() {

    val people = People(18, "Female")

    val properties = People::class.memberProperties
    val functions = People::class.memberFunctions

    println("Properties:")
    for (property in properties) {
        property.isAccessible = true
        println("${property.name}: ${property.get(people)}")
    }

    println("memberFunctions:")
    for (method in functions) {
        method.isAccessible = true
        if (method.name == "getPeopleAge" || method.name == "getPeopleGender") {
            println("${method.name}: ${method.call(people)}")
        }
    }
}