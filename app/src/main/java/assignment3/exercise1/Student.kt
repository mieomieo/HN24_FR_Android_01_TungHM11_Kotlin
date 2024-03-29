package assignment3.exercise1

import java.util.Scanner

class Student : Person() {

    private var _studentId: String = ""

    var studentId: String
        get() = _studentId
        set(value) {
            _studentId = value
        }
    private var _gpa: Double = 0.0
    var gpa: Double
        get() = _gpa
        set(value) {
            _gpa = value
        }
    private var _email: String = ""
    var email: String
        get() = _email
        set(value) {
            _email = value
        }

    companion object {
        val listId = mutableListOf<String>()
    }

    override fun inputInfo() {
        val scanner = Scanner(System.`in`)

        do {
            print("Enter student ID (Prefix must be 'SV', e.g., SV01):")
            studentId = readln()
            if (!studentId.matches("^SV\\d++$".toRegex())) {
                println("Invalid fomat.(Prefix must be 'SV', e.g., SV01)")
            } else if (!isStudentIdUnique()) {
                println("Student ID is already existed. Try again")
            }
        } while (!studentId.matches("^SV\\d++$".toRegex()) || !isStudentIdUnique())

        listId.add(studentId)

        super.inputInfo()

        do {
            print("Enter GPA: ")
            val input = scanner.nextLine()
            gpa = input.toDoubleOrNull() ?: Double.MIN_VALUE

            if (gpa == Double.MIN_VALUE || !Validate.isValidateGPA(gpa)) {
                println("Invalid input. Please enter a valid GPA between 0.0 and 10.0.")
            }
        } while (gpa == Double.MIN_VALUE || !Validate.isValidateGPA(gpa))

        do {
            print("Enter email: ")
            email = scanner.nextLine().trim { it <= ' ' }
            if (!Validate.isValidateEmail(email)) {
                println("Invalid email format. Please try again")
                println("Example: hmtung@gmail.com")
            }
        } while (!Validate.isValidateEmail(email))
    }

    override fun showInfo() {
        println(
            "| ${studentId.padEnd(12)}| ${name.padEnd(21)}| ${gender.padEnd(9)}| ${dob.padEnd(11)}| ${
                address.padEnd(
                    22
                )
            }| ${email.padEnd(17)}| ${gpa.toString().padEnd(5)}| ${
                setScholarship().toString().padEnd(12)
            }|"
        )
        println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
    }

     fun isStudentIdUnique(): Boolean {
        return !listId.contains(studentId)
    }

    fun setScholarship(): Boolean {
        return gpa >= 8.0
    }
}