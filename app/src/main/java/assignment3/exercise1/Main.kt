package assignment3.exercise1

import java.util.Scanner
//Bài 1. Xây dựng chương trình quản lý danh sách sinh viên, giảng
//viên. Thông tin bao gồm:
//Tạo lớp Person chứa các thông tin:
//Tên, giới tính, ngày sinh, address
//1. Tạo lớp Person có primary, second constructor
//2. Viết method inputInfo() để nhập thông tin từ bàn phím
//3. Viêt method showInfo() để hiển thị toàn bộ thông tin
//Tạo lớp Student kế thừa các thông tin của Person
//Và có các thông tin sau: mã sv(prefix của id: SV. Example: SV01), điểm
//trung bình (0.0 -&gt; 10.0),
//email: phải chưa @ và không tồn tại khoảng trắng
//1. Override lại method inputInfo() để nhập thông tin
//2. Override lại method showInfo() để hiển thị thông tin sinh viên
//3. Viết method set học bổng cho sinh viên (&gt;= 8.0 thì sẽ nhận học bổng)
//Tạo lớp Teacher kế thừa từ Person.
//Và có các thông tin sau:
//Mã gv(prefix của id: GV. Example: GV01)
//Lớp dạy (phải bắt đầu = các chữ: G, H, I, K, L, M. Example: G1)
//Lương một giờ dạy, số giờ dạy trong tháng
//1. Override lại method inputInfo() để nhập thông tin
//2. Override lại method showInfo() để hiển thị thông tin giảng viên
//3. Viết method tính lương cho Teacher:
//Nếu dạy lớp là lớp buổi sáng và buổi chiều (G, H, I, K) thì:
//-&gt; Lương thực nhận = lương 1h dạy * số h dạy trong tháng
//Nếu dạy lớp là lớp buổi tối (L, M)
//-&gt; Lương thực nhận = lương 1h dạy * số h dạy trong tháng + 500000
//Chương trình có menu tùy chọn sau:
//1. Thêm sinh viên/giảng viên.
//2. Sửa sinh viên/giảng viên theo mã.
//3. Xóa sinh viên/giảng viên theo mã.
//4. Sắp xếp sinh viên/giảng viên theo họ tên.
//5. Hiển thị thông tin tất cả sinh viên
//6. Hiển thị thông tin tất cả giảng viên
//7. Sắp xếp và hiển thị sinh viên theo điểm trung bình.
//8. Sắp xếp và hiển thị giảng viên theo lương.
//0. Thoát chương trình.
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
        scanner.nextLine()
        when (choice) {
            1 -> {
                println("Add new person:")
                do {
                    println("Enter \"1\" to add student, enter \"2\" to add teacher, enter \"0\" to return menu: ")
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
                    else if(option == 0){
                        break;
                    }
                } while (option != 1 && option != 2)
            }

            2 -> editPerson(students,teachers,scanner)
            3 -> deletePerson(students,teachers,scanner)
            4 -> sortPerson(students,teachers,scanner)
            5 -> {
                if (students.isEmpty()) {
                    println("Empty student data")
                } else {
                    println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                    println("| ID          | Name                 | Gender   | DOB        | Address               |  Email           | GPA  | Scholarship |")
                    println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                    for (student in students) {
                        student.showInfo()
                    }
                }

            }

            6 -> if (teachers.isEmpty()) {
                println("Empty teacher data")
            } else {
                println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                println("| ID          | Name                 | Gender   | DOB        | Address               |  Email           | GPA  | Scholarship |")
                println("+-------------+----------------------+----------+------------+-----------------------+------------------+------+-------------+")
                for (teacher in teachers) {
                    teacher.showInfo()
                }
            }

            7 -> TODO()
            8 -> TODO()
            0 -> println("Exiting program.")

        }
    } while (choice != 0)
}

