package assignment3.exercise1


import java.text.Normalizer
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
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt()
                break
            } else {
                println("Invalid input. Please enter a valid integer.")
                scanner.next()
            }
        }
        scanner.nextLine()
        when (choice) {
            1 -> {
                println("Add new person:")
                do {
                    println("Enter \"1\" to add student, enter \"2\" to add teacher, enter \"0\" to return menu: ")
                    val option = scanner.nextInt()
                    if (option == 1) {
                        val student = Student()
                        student.inputInfo()
                        students.add(student)
                        println("Student added successfully")
                    } else if (option == 2) {
                        val teacher = Teacher()
                        teacher.inputInfo()
                        teachers.add(teacher)
                        println("Teacher added successfully")
                    } else if (option == 0) {
                        break;
                    }
                } while (option != 1 && option != 2)
            }

            2 -> editPerson(students, teachers, scanner)
            3 -> deletePerson(students, teachers, scanner)
            4 -> sortPerson(students, teachers, scanner)
            5 -> {
                if (students.isEmpty()) {
                    println("Empty student data")
                } else {
                    tableStudent()
                    for (student in students) {
                        student.showInfo()
                    }
                }

            }

            6 -> if (teachers.isEmpty()) {
                println("Empty teacher data")
            } else {
                tableTeacher()
                for (teacher in teachers) {
                    teacher.showInfo()
                }
            }

            7 -> {
                println("Sort and display students by GPA:")
                students.sortBy { it.gpa }
                tableStudent()
                for (student in students) {
                    student.showInfo()
                }

            }

            8 -> {
                println("Sort and display teachers by salary:")
                teachers.sortBy { it.getSalary() }
                tableTeacher()
                for (teacher in teachers) {
                    teacher.showInfo()
                }
            }

            0 -> println("Exiting program.")
            else -> {
                println("Invalid option")
            }

        }
    } while (choice != 0)
}

fun deletePerson(students: MutableList<Student>, teachers: MutableList<Teacher>, scanner: Scanner) {

    fun <T> delete(type: MutableList<T>, scanner: Scanner) {
        println("Enter ${if (type.firstOrNull() is Student) "student" else "teacher"} ID to delete: ")
        var entityId: String? = scanner.nextLine().trim()

        while (entityId.isNullOrEmpty()) {
            println("${if (type.firstOrNull() is Student) "Student" else "Teacher"} ID cannot be empty. Please enter a valid ${if (type.firstOrNull() is Student) "student" else "teacher"} ID.")
            entityId = scanner.nextLine().trim()
        }

        val entityIndex = type.indexOfFirst {
            when (it) {
                is Student -> it.studentId == entityId
                is Teacher -> it.teacherId == entityId
                else -> false
            }
        }

        if (entityIndex != -1) {
            type.removeAt(entityIndex)
            println("${if (type.firstOrNull() is Student) "Student" else "Teacher"} deleted successfully.")
        } else {
            println("${if (type.firstOrNull() is Student) "Student" else "Teacher"} not found with ID: $entityId")
        }
    }
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
            1 -> delete(students, scanner)
            2 -> delete(teachers, scanner)
            0 -> return
        }

    } while (deleteOption == null)

}


fun editPerson(students: MutableList<Student>, teachers: MutableList<Teacher>, scanner: Scanner) {
    fun <T> editPerson(
        type: MutableList<T>,
        entityType: String,
        scanner: Scanner,
        idExtractor: (T) -> String,
        editFunction: (T) -> Unit,
        listId: MutableList<String>
    ) {
        println("Enter $entityType ID to edit: ")
        val entityId = scanner.next()
        val entityIndex = type.indexOfFirst { idExtractor(it) == entityId }


        if (entityIndex != -1) {
            val existingId = idExtractor(type[entityIndex])
            if (existingId in listId) {
                listId.remove(existingId)
            }
            editFunction(type[entityIndex])
            println("$entityType information updated successfully.")
        } else {
            println("$entityType not found with ID: $entityId")
        }
    }

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
                    editPerson(students, "student", scanner, { it.studentId }, { student -> student.inputInfo() }, Student.listId)

                    println("Student updated successfully")
                }
            }

            2 -> {
                if (teachers.isEmpty()) {
                    println("Empty data")
                } else {
                    editPerson(teachers, "teacher", scanner, { it.teacherId }, { teacher -> teacher.inputInfo() }, Teacher.listId)
                    println("Teacher updated successfully")
                }
            }

            0 -> return
        }

    } while (editOption == null)
}

fun sortPerson(students: MutableList<Student>, teachers: MutableList<Teacher>, scanner: Scanner) {
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
                    students.sortWith(Comparator.comparing {
                        it.name.split(" ").last().toLowerCase().removeDiacritics()
                    })
                    println("Student sorted successfully")
                    tableStudent()
                    for (student in students) {
                        student.showInfo()
                    }
                }
            }

            2 -> {
                if (teachers.isEmpty()) {
                    println("Empty data")
                } else {
                    teachers.sortWith(Comparator.comparing {
                        it.name.split(" ").last().toLowerCase().removeDiacritics()
                    })
                    println("Teacher sorted successfully")
                    tableTeacher()
                    for (teacher in teachers) {
                        teacher.showInfo()
                    }

                }
            }

            0 -> return
        }

    } while (sortOption == null)
}

fun String.removeDiacritics(): String {
    val temp = Normalizer.normalize(this, java.text.Normalizer.Form.NFD)
    return temp.replace(Regex("\\p{InCombiningDiacriticalMarks}+"), "")
}

fun tableStudent() {
    println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
    println("| ID          | Name                 | Gender   | DOB        | Address               |  Email           | GPA  | Scholarship |")
    println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
}

fun tableTeacher() {
    println("+-------------+---------------+----------------------+----------+------------+-----------------------+----------------------+")
    println("| ID          | Class         | Name                 | Gender   | DOB        | Address               |  Salary              |")
    println("+-------------+---------------+----------------------+----------+------------+-----------------------+----------------------+")
}