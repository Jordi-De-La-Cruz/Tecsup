package com.example.tecsup.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecsup.network.ApiService
import com.example.tecsup.userlist.UserListResponse
import com.example.tecsup.userlist.User // Agrega esta línea de importación
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class UserListViewModel : ViewModel() {

    private val apiService = ApiService.apiService

    val userListLiveData: MutableLiveData<List<User>> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun fetchUserList() {
        apiService.getUsers(2)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                userListLiveData.value = response.users
            }, { error ->
                errorLiveData.value = error.localizedMessage
            })
    }
}
