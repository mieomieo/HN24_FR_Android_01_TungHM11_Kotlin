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
    println("Enter '1' to delete student, enter '2' to delete teacher: ")
    val deleteOption = scanner.nextInt()
    if (deleteOption == 1) {
        deleteStudent(students, scanner)
    } else if (deleteOption == 2) {
//        deleteTeacher(teachers, scanner)
    }
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
    println("Enter '1' to edit student, enter '2' to edit teacher: ")
    val editOption = scanner.nextInt()
    if (editOption == 1) {
        if(students.isEmpty()){
            println("Empty student")
        }
        else{
            editStudent(students, scanner)
        }

    } else if (editOption == 2) {
        if(teachers.isEmpty()){
            println("Empty student")
        }
        else{

        }
//            editTeacher(teachers, scanner)
    }

}