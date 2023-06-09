package com.example.tecsup.login

import com.example.tecsup.network.ApiService
import com.example.tecsup.network.LoginRequest
import com.example.tecsup.network.LoginResponse
import io.reactivex.rxjava3.core.Single

class LoginRepository {

    private val api = ApiService.apiService

    fun login(email: String, pass: String): Single<LoginResponse> {
        return api.login(LoginRequest(email, pass))
    }

}
