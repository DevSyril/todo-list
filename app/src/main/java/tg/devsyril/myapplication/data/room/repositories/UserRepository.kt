package tg.devsyril.myapplication.data.room.repositories

import kotlinx.coroutines.flow.Flow
import tg.devsyril.myapplication.data.room.daos.UserDao
import tg.devsyril.myapplication.data.room.models.User

class UserRepository(
    private val userDao: UserDao
) {
    val usersList = userDao.usersList()

    suspend fun register(user: User) { userDao.register(user)}

    fun getUserByEmail(email: String): Flow<List<User>> = userDao.getUSerByEmail(email)
    fun activateUserByEmail(email: String) = userDao.activateUserByEmail(email)
}