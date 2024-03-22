package final

import kotlinx.coroutines.*
import java.util.Scanner

fun main() {
    val userManager = UserManager()
    val scanner = Scanner(System.`in`)

    var choice: Int
    do {
        println("**Menu**")
        println("1. Add user")
        println("2. Find user")
        println("3. Sort user by name")
        println("4. Display users")
        println("0. Exit")
        print("Please select a task: ")
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt()
                break
            } else {
                println("Invalid input. Please enter a valid integer.")
                scanner.next()
            }
        }

        when(choice) {
            1 -> {
                var numberUser: Int
                while (true) {
                    print("Enter number user want to add: ")
                    if (scanner.hasNextInt()) {
                        numberUser = scanner.nextInt()
                        if (numberUser > 0) {
                            break
                        } else {
                            println("Please enter a positive integer.")
                        }
                    } else {
                        println("Invalid input. Please enter a valid integer.")
                        scanner.next()
                    }
                }

                for (i in 0 until numberUser)
                {
                    val user = User()
                    user.input()
                    GlobalScope.launch {
                        userManager.addUser(user)
                    }
                }
                Thread.sleep(2000)
                println("List of Users:")
                println("+----------------------+-------------+----------------------+")
                println("| Name                 | Age         |  Email               |")
                println("+----------------------+-------------+----------------------+")
                userManager.displayUsers()

            }
            2 -> {
                print("Search name: ")
                val searchName = readLine().toString()
                val findUsers = userManager.findUserByName(searchName)

                println("Users with name '$searchName':")
                println("+----------------------+-------------+----------------------+")
                println("| Name                 | Age         |  Email               |")
                println("+----------------------+-------------+----------------------+")
                if(findUsers.isEmpty()){
                    println("+----------           NO DATA             ------------------+")
                    println("+----------------------+-------------+----------------------+")
                }else{
                    for (user in findUsers) {
                        println(
                            "| ${user.name.padEnd(21)}| ${
                                user.age.toString().padEnd(12)
                            }| ${user.email.padEnd(21)}|"
                        )
                        println("+----------------------+-------------+----------------------+")
                    }
                }

            }
            3-> {
                userManager.sortUserName()
                println("List of user after sorted by name:")
                println("+----------------------+-------------+----------------------+")
                println("| Name                 | Age         |  Email               |")
                println("+----------------------+-------------+----------------------+")
                userManager.displayUsers()
            }
            4-> {
                println("List of Users:")
                println("+----------------------+-------------+----------------------+")
                println("| Name                 | Age         |  Email               |")
                println("+----------------------+-------------+----------------------+")
                userManager.displayUsers()
            }
            0 -> {
                print("Exit")
            }
            else -> {
                println("Invalid option")
            }
        }
    }while (choice!=0)
}
