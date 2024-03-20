package assignment3.exercise1

import java.util.Scanner

class Student : Person() {
    private var studentId:String =""
    private var gpa:Double = 0.0
    private var email:String =""
    private val idPrefix ="SV"
    override fun inputInfo() {
        val scanner = Scanner(System.`in`)
        println("Enter student id: $idPrefix")
        studentId = idPrefix + scanner.nextLine()
        super.inputInfo()
        println("Enter gpa: ")
        gpa = scanner.nextDouble()
        scanner.nextLine()
        println("Enter email: ")
        email = scanner.nextLine()
    }

    override fun showInfo() {
        println("| ${studentId.padEnd(12)}| ${super.name.padEnd(21)}| ${super.gender.padEnd(9)}| ${super.dob.padEnd(11)}| ${super.address.padEnd(22)}| ${email.padEnd(17)}| ${gpa.toString().padEnd(6)}| ${setScholarship().toString().padEnd(12)}|")
        println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
    }
    fun setScholarship() : Boolean {
        return gpa >= 8.0
    }
}