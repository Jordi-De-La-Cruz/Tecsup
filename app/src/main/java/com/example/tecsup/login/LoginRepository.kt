package com.example.tecsup.login

class LoginRepository {

    fun login(email: String, pass: String): Boolean{
        return email == "jordi.delacruz@tecsup.edu.pe" && pass == "123"
    }

}
