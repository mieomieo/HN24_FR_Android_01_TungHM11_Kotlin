package assignment3.exercise1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var students = mutableListOf<Student>()
    var teachers = mutableListOf<Teacher>()
    var choice: Int
    do {
        println("\n1. Add a student/teacher")
        println("2. Edit a student/teacher by ID")
        println("3. Delete a student/teacher by ID")
        println("4. Sort students/teachers by name")
        println("5. Display all students")
        println("6. Display all teachers")
        println("7. Sort and display students by GPA")
        println("8. Sort and display teachers by salary")
        println("0. Exit")
        print("Enter your choice: ")
        choice = scanner.nextInt()
        when (choice) {
            1 -> {
                println("Add new person:")
                do {
                    println("Enter `1` to add student, enter `2` to add teacher: ")
                    val option = scanner.nextInt();
                    if (option == 1) {
                        val student = Student()
                        student.inputInfo()
                        students.add(student)
                    } else if (option == 2) {
                        val teacher = Teacher()
                        teacher.inputInfo()
                        teachers.add(teacher)
                    }
                } while (option != 1 && option != 2)
            }

            2 -> TODO()
            3 -> {
                println("Delete person:")
                do {
                    println("Enter `1` to delete student, enter `2` to delete teacher: ")
                    val option = scanner.nextInt();
                    if (option == 1) {
                        val student = Student()
                        students.add(student)
                    } else if (option == 2) {
                        val teacher = Teacher()
                        teacher.inputInfo()
                        teachers.add(teacher)
                    }
                } while (option != 1 && option != 2)
            }
            4 -> TODO()
            5 ->{
                println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                println("| ID          | Name                 | Gender   | DOB        | Address               |  Email           | GPA  | Scholarship |")
                println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                for (student in students) {
                    student.showInfo()
                }
            }

            6 -> TODO()
            7 -> TODO()
            8 -> TODO()
            0 -> println("Exiting program.")

        }
    } while (choice != 0)

}