package assignment3.exercise1

import java.util.Scanner

fun deletePerson(students: MutableList<Student>, teachers: MutableList<Teacher>, scanner: Scanner) {
    fun deleteStudent(students: MutableList<Student>, scanner: Scanner) {
        println("Enter student ID to delete: ")
        val studentId = scanner.next()
        val studentIndex = students.indexOfFirst { it.studentId == studentId }
        if (studentIndex != -1) {
            students.removeAt(studentIndex)
            println("Student deleted successfully.")
        } else {
            println("Student not found with ID: $studentId")
        }
    }
//    fun deleteTeacher(teachers: MutableList<Teacher>, scanner: Scanner) {
//        println("Enter teacher ID to delete: ")
//        val teacherId = scanner.next()
//        val teacherIndex = teachers.indexOfFirst { it.teacherId == teacherId }
//        if (teacherIndex != -1) {
//            teachers.removeAt(teacherIndex)
//            println("Teacher deleted successfully.")
//        } else {
//            println("Teacher not found with ID: $teacherId")
//        }
//    }

    println("Delete person:")
    println("Enter '1' to delete student, enter '2' to delete teacher, enter \"0\" to return menu: ")

    do {

        val input = scanner.nextLine()
        val deleteOption: Int? = input.toIntOrNull()
        if (deleteOption == null) {
            println("Invalid option. Please try again")
            println("Enter '1' to delete student, enter '2' to delete teacher, enter \"0\" to return menu: ")
        }
        when (deleteOption) {
            1 -> deleteStudent(students, scanner)
//        2-> deleteTeacher(teachers, scanner)
            0 -> return
        }

    } while (deleteOption == null)

}


fun editPerson(students: MutableList<Student>, teachers: MutableList<Teacher>, scanner: Scanner) {

    fun editStudent(students: MutableList<Student>, scanner: Scanner) {
        println("Enter student ID to edit: ")
        val studentId = scanner.next()
        val studentIndex = students.indexOfFirst { it.studentId == studentId }
        if (studentIndex != -1) {
            val student = students[studentIndex]
            student.inputInfo()
            println("Student information updated successfully.")
        } else {
            println("Student not found with ID: $studentId")
        }
    }
//        fun editTeacher(teachers: MutableList<Teacher>, scanner: Scanner) {
//            println("Enter teacher ID to edit: ")
//            val teacherId = scanner.next()
//            val teacherIndex = teachers.indexOfFirst { it.teacherId == teacherId }
//            if (teacherIndex != -1) {
//                val teacher = teachers[teacherIndex]
//                teacher.inputInfo()
//                println("Teacher information updated successfully.")
//            } else {
//                println("Teacher not found with ID: $teacherId")
//            }
//        }
    println("Edit person:")
    println("Enter '1' to edit student, enter '2' to edit teacher, enter \"0\" to return menu: ")
    do {
        val input = scanner.nextLine()
        val editOption: Int? = input.toIntOrNull()
        if (editOption == null) {
            println("Invalid option. Please try again")
            println("Enter '1' to edit student, enter '2' to edit teacher, enter \"0\" to return menu: ")
        }
        when (editOption) {
            1 -> {
                if (students.isEmpty()) {
                    println("Empty data")
                } else {
                    editStudent(students, scanner)
                }
            }

            2 -> TODO()
            0 -> return
        }

    } while (editOption == null)

}
fun sortPerson(students:MutableList<Student>, teachers: MutableList<Teacher>, scanner: Scanner ){
    println("Sort person:")
    println("Enter '1' to sort student, enter '2' to sort teacher, enter \"0\" to return menu: ")
    do {
        val input = scanner.nextLine()
        val sortOption: Int? = input.toIntOrNull()
        if (sortOption == null) {
            println("Invalid option. Please try again")
            println("Enter '1' to sort student, enter '2' to sort teacher, enter \"0\" to return menu: ")
        }
        when (sortOption) {
            1 -> {
                if (students.isEmpty()) {
                    println("Empty data")
                } else {
                    students.sortBy { it.name }
                    println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                    println("| ID          | Name                 | Gender   | DOB        | Address               |  Email           | GPA  | Scholarship |")
                    println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                    for (student in students) {
                        student.showInfo()
                    }
                }
            }

            2 -> {
                if (teachers.isEmpty()) {
                    println("Empty data")
                } else {
                    teachers.sortBy { it.name }
                }
            }
            0 -> return
        }

    } while (sortOption == null)
}