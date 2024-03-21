package assignment3.exercise1

import java.util.Scanner

class Teacher : Person() {

    private var _teacherId: String = ""

    var teacherId: String
        get() = _teacherId
        set(value) {
            _teacherId = value
        }

    private var _classTaught: String = ""

    var classTaught: String
        get() = _classTaught
        set(value) {
            _classTaught = value
        }

    private var _hourlySalary: Double = 0.0

    var hourlySalary: Double
        get() = _hourlySalary
        set(value) {
            _hourlySalary = value
        }

    private var _hoursTaught: Int = 0

    var hoursTaught: Int
        get() = _hoursTaught
        set(value) {
            _hoursTaught = value
        }

    companion object {
        val listId = mutableListOf<String>()
    }

    override fun inputInfo() {
        val scanner = Scanner(System.`in`)

        do {
            print("Enter teacher ID (Prefix must be 'GV', e.g., GV01):")
            teacherId = readLine().toString()
            if (!teacherId.matches("^GV\\d++$".toRegex())) {
                println("Invalid format. Prefix must be 'GV', e.g., GV01")
            } else if (!isTeacherIdUnique()) {
                println("Teacher ID is already existed. Try again")
            }
        } while (!teacherId.matches("^GV\\d++$".toRegex()) || !isTeacherIdUnique())

        listId.add(teacherId)

        super.inputInfo()

        do {
            print("Enter class taught (Start with G, H, I, K, L, M): ")
            classTaught = scanner.nextLine().trim()
            if (!classTaught.matches("^[GHIKLM]\\d++$".toRegex())) {
                println("Invalid class. Class must start with G, H, I, K, L, M. Example: G1)")
            }
        } while (!classTaught.matches("^[GHIKLM]\\d++$".toRegex()))
        do {
            var checkValid = false
            print("Enter hourly salary: ")
            val input = scanner.nextLine().trim()
            if (!input.matches("^\\d*\\.?\\d+$".toRegex())) {
                println("Invalid input. Please enter a valid number for hourly salary.")
                continue
            }
            val hourlySalaryValue = input.toDouble()
            if (hourlySalaryValue <= 0) {
                println("Invalid input. Hourly salary must be a positive number.")
                continue
            }
            checkValid = true
            hourlySalary = hourlySalaryValue
        } while (!checkValid)

        do {
            var checkValid = false
            print("Enter hours taught in the month: ")
            val input = scanner.nextLine().trim()
            if (!input.matches("^\\d+$".toRegex())) {
                println("Invalid input. Please enter a valid integer for hours taught.")
                continue
            }
            val hoursTaughtValue = input.toInt()
            if (hoursTaughtValue <= 0) {
                println("Invalid input. Hours taught must be a positive integer.")
                continue
            }
            checkValid = true
            hoursTaught = hoursTaughtValue
        } while (!checkValid)
    }

    override fun showInfo() {
        println(
            "| ${teacherId.padEnd(12)}| ${classTaught.padEnd(14)}| ${name.padEnd(21)}| ${
                gender.padEnd(
                    9
                )
            }| ${dob.padEnd(11)}| ${
                address.padEnd(
                    22
                )
            }| ${
                getSalary().toString().padEnd(
                    21
                )
            }|"
        )
        println("+-------------+---------------+----------------------+----------+------------+-----------------------+----------------------+")
    }

    private fun isTeacherIdUnique(): Boolean {
        return !listId.contains(teacherId)
    }

    private fun calculateSalary(): Double {
        return if (classTaught.startsWith("G") || classTaught.startsWith("H") || classTaught.startsWith(
                "I"
            ) || classTaught.startsWith(
                "K"
            )
        ) {
            hourlySalary * hoursTaught
        } else {
            hourlySalary * hoursTaught + 500000
        }
    }
    fun getSalary():Double {
        return calculateSalary()
    }
}
