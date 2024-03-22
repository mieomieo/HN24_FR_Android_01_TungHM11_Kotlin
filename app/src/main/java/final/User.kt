package final


import java.util.Scanner

open class User(
    var name:String="",
    var age:Int=0,
    var email:String=""
) {
    constructor() : this("", 0,  "")

    open fun input() {
        val scanner = Scanner(System.`in`)

        do {
            print("Enter name: ")
            name = scanner.nextLine().trim { it <= ' ' }
            if (name.isEmpty()) {
                println("Name cannot be empty. Please try again.")
            }
        } while (name.isEmpty())

        do {
            print("Age: ")
            if (scanner.hasNextInt()) {
                age = scanner.nextInt()
                if (age >= 0) {
                    break
                } else {
                    println("Invalid age. Please enter a non-negative integer.")
                }
            } else {
                println("Invalid input. Please enter a valid integer.")
            }
        } while (true)
        scanner.nextLine()

        do {
            print("Enter email: ")
            email = scanner.nextLine().trim { it <= ' ' }
            if (!Validate.isValidateEmail(email)) {
                println("Invalid email format. Please try again. Example: hmtung@gmail.com")
            }
        } while (!Validate.isValidateEmail(email))
    }
}
