package assignment4.exercise4


class People(val age: Int, private val gender: String) {
    fun getPeopleAge(): Int {
        return age
    }

    private fun getPeopleGender(): String {
        return gender
    }
}