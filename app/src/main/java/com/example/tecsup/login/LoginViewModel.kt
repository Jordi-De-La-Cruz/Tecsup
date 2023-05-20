package com.example.tecsup.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    private val repository = LoginRepository()

    val userLoginStringError = MutableLiveData<String>()
    val userLoginServiceResponse = MutableLiveData<Boolean>()

    fun login(email: String, pass: String){
        if (email.isEmpty() || pass.isEmpty()){
            userLoginStringError.value = "Verifique sus credenciales"
        }else{
            userLoginServiceResponse.value = repository.login(email, pass)
        }
    }

}