package com.example.tecsup.user

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tecsup.database.TecsupDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(application: Application) {
    private val userDao: UserDAO? = TecsupDataBase.getInstance(application)?.userDao()

    suspend fun insertUserWithCoroutines(user: User) {
        processInsertUser(user)
    }

    private suspend fun processInsertUser(user: User) {
        withContext(Dispatchers.Default) {
            userDao?.insert(user)
        }
    }

    fun getUsers(): LiveData<List<User>>? {
        return userDao?.getUsers()
    }
}
