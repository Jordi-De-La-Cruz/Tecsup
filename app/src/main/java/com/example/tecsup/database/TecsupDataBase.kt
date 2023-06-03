package com.example.tecsup.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tecsup.note.Note
import com.example.tecsup.note.NoteDAO
import com.example.tecsup.user.User
import com.example.tecsup.user.UserDAO

@Database(entities = [Note::class, User::class], version = 2)
abstract class TecsupDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDAO
    abstract fun userDao(): UserDAO

    companion object {
        private const val DATABASE_NAME = "tecsup_database"

        @Volatile
        private var INSTANCE: TecsupDataBase? = null

        fun getInstance(context: Context): TecsupDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TecsupDataBase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
