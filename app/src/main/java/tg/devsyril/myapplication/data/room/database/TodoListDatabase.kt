package tg.devsyril.myapplication.data.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tg.devsyril.myapplication.data.room.daos.OTPCodeDao
import tg.devsyril.myapplication.data.room.daos.UserDao
import tg.devsyril.myapplication.data.room.models.OTPCode
import tg.devsyril.myapplication.data.room.models.User


@Database(
    entities = [User::class, OTPCode::class],
    version = 2,
    exportSchema = false
)

abstract class TodoListDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun otpCodeDao(): OTPCodeDao

    companion object {
        @Volatile
        var INSTANCE: TodoListDatabase? = null
        fun getDatabase(context: Context): TodoListDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context,
                    TodoListDatabase::class.java,
                    name = "todolist_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                return instance
            }
        }
    }
}