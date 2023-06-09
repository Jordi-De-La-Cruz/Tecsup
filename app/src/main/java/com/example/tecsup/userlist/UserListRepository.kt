package com.example.tecsup.userlist

import com.example.tecsup.network.ApiService
import com.example.tecsup.userlist.UserListResponse // Importación corregida
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class UserListRepository {

    private val apiService = ApiService.apiService

    fun getUsers(page: Int): Single<UserListResponse> {
        return apiService.getUsers(page)
            .subscribeOn(Schedulers.io())
    }
}
