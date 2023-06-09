package com.example.tecsup.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecsup.network.LoginResponse
import com.example.tecsup.userlist.UserListRepository
import com.example.tecsup.userlist.UserListResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginViewModel : ViewModel() {

    private val repository = LoginRepository()
    private val userListRepository = UserListRepository()

    // MutableLiveData
    val userLoginStringError = MutableLiveData<String>()
    val userLoginServiceResponse = MutableLiveData<Boolean>()

    val userListResponse = MutableLiveData<UserListResponse>()
    val userListError = MutableLiveData<String>()

    private val disposable = CompositeDisposable()

    fun login(email: String, pass: String) {
        if (email.isEmpty() || pass.isEmpty()) {
            userLoginStringError.value = "Verifique sus credenciales"
        } else {
            loginService(email, pass)
        }
    }

    fun loginService(email: String, pass: String) {
        disposable.add(
            repository.login(email, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {

                    override fun onSuccess(t: LoginResponse) {
                        userLoginServiceResponse.value = true
                    }

                    override fun onError(e: Throwable) {
                        userLoginServiceResponse.value = false
                    }

                })
        )
    }

    fun getUsers(page: Int) {
        disposable.add(
            userListRepository.getUsers(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<UserListResponse>() {
                    override fun onSuccess(response: UserListResponse) {
                        userListResponse.value = response
                    }

                    override fun onError(e: Throwable) {
                        userListError.value = "Error al obtener la lista de usuarios"
                    }
                })
        )
    }
}
