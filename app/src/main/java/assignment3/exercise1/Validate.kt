package assignment3.exercise1

import java.util.regex.Pattern

interface Validate {
    companion object {
        fun isValidDateOfBirth(input: String): Boolean {
            return input.let { Pattern.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}", it) }
        }
        fun isValidGender(input: String): Boolean {
            return input.equals("Male", ignoreCase = true) || input.equals("Female", ignoreCase = true)
        }
        fun isValidateEmail(email: String): Boolean {
            val regexEmail = Regex("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")
            return regexEmail.matches(email)
        }
        fun isValidateGPA(gpa:Double):Boolean{
            return gpa in 0.0..10.0
        }

    }


}