package tg.devsyril.myapplication.data.room.database

import android.content.Context
import tg.devsyril.myapplication.data.room.repositories.OTPCodeRepository
import tg.devsyril.myapplication.data.room.repositories.UserRepository

object Graph {

    private lateinit var todoListDatabase: TodoListDatabase
        private set

    val userRepository by lazy {
        UserRepository(
            userDao = todoListDatabase.userDao()
        )
    }

    val otpCodeRepository by lazy {
        OTPCodeRepository(
            otpCodeDao = todoListDatabase.otpCodeDao()
        )
    }

    fun provide(context: Context){
        todoListDatabase = TodoListDatabase.getDatabase(context = context)
    }

}