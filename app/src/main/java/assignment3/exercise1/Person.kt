package assignment3.exercise1

import java.util.Scanner

open class Person(var name: String = "", var gender: String = "", var dob: String = "", var address: String = "") {
    constructor() : this("", "", "", "")
    open fun inputInfo() {
        val scanner = Scanner(System.`in`)
        do {
            print("Enter name: ")
            name = scanner.nextLine().trim { it <= ' ' }
            if (name.isEmpty()) {
                println("Name cannot be empty. Please try again.")
            }
        } while (name.isEmpty())


        do{
            print("Gender (Male/Female): ")
            gender = scanner.nextLine().trim { it <= ' ' }
            if (!Validate.isValidGender(gender)) {
                println("Invalid gender. Gender must be 'Male' or 'Female'. Please try again.")
            }
        }while(!Validate.isValidGender(gender))


        do {
            print("Date of Birth (dd/mm/yyyy): ")
            dob = scanner.nextLine().trim { it <= ' ' }
            if (!Validate.isValidDateOfBirth(dob)) {
                println("Invalid date format. Date f Birth must be in dd/mm/yyyy format. Please try again.")
            }
        } while (!Validate.isValidDateOfBirth(dob))


        do {
            print("Enter address: ")
            address = scanner.nextLine().trim { it <= ' ' }
            if (address.isEmpty()) {
                println("Address cannot be empty. Please try again.")
            }
        } while (address.isEmpty())

    }
    open fun showInfo() {

        println("Name: $name")
        println("Gender: $gender")
        println("Date of Birth: $dob")
        println("Address: $address")

    }
}
