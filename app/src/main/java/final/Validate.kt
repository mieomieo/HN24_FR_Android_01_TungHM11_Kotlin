package final
interface Validate {
    companion object {
        fun isValidateEmail(email: String): Boolean {
            val regexEmail = Regex("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")
            return regexEmail.matches(email)
        }
    }
}