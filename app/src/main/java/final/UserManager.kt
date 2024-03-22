package final

import kotlinx.coroutines.delay
import java.text.Normalizer
import kotlin.random.Random


open class UserManager {
    private val users = ArrayList<User>()

    suspend fun addUser(user: User) {
        val randomDelay = Random.nextLong(500, 2000)
        delay(randomDelay)
        users.add(user)
        print("                              Added user: ${user.name} successfully!")
    }

    fun displayUsers() {
        if (users.isEmpty()) {
            println("+----------           NO DATA             ------------------+")
            println("+----------------------+-------------+----------------------+")
        } else {
            for (user in users) {
                println(
                    "| ${user.name.padEnd(21)}| ${
                        user.age.toString().padEnd(12)
                    }| ${user.email.padEnd(21)}|"
                )
                println("+----------------------+-------------+----------------------+")
            }
        }

    }

    fun sortUserName() {
        users.sortWith(Comparator.comparing {
            it.name.split(" ").last().toLowerCase().removeDiacritics()
        })
    }

    fun String.removeDiacritics(): String {
        val temp = Normalizer.normalize(this, java.text.Normalizer.Form.NFD)
        return temp.replace(Regex("\\p{InCombiningDiacriticalMarks}+"), "")
    }

    fun findUserByName(name: String): List<User> {
        return users.filter { it.name.contains(name) }
    }
}
