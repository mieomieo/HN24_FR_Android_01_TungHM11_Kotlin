package assignment3.exercise1

import java.util.Scanner

open class Person(var name: String = "", var gender: String = "", var dob: String = "", var address: String = "") {
    constructor() : this("", "", "", "")
    open fun inputInfo() {
        val scanner = Scanner(System.`in`)
        print("Enter name: ")
        name = scanner.nextLine()
        print("Enter gender: ")
        gender = scanner.nextLine()
        print("Enter date of birth: ")
        dob = scanner.nextLine()
        print("Enter address: ")
        address = scanner.nextLine()
    }
    open fun showInfo() {

        println("Name: $name")
        println("Gender: $gender")
        println("Date of Birth: $dob")
        println("Address: $address")
        println("+-------------+-----------------+----------+-----------+-----------------------+-------+-----------------+")
    }
}