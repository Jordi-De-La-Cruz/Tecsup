package com.example.tecsup.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository = UserRepository(application)
    val users = repository.getUsers()

    fun saveUser(user: User) {
        viewModelScope.launch {
            repository.insertUserWithCoroutines(user)
        }
    }
}
