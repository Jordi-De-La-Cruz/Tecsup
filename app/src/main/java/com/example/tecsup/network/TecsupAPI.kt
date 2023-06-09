package com.example.tecsup.network

import com.example.tecsup.userlist.UserListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TecsupAPI {

    // https://reqres.in/api/login
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    // https://reqres.in/api/users?page=2&limit=100
    //@GET("users")
    //fun listUser(@Query("page") page: Int, @Query("limit") limit: Int): Single<List<LoginResponse>>

    // https://reqres.in/api/users?page=2
    @GET("users")
    fun getUsers(@Query("page") page: Int): Single<UserListResponse>

    // https://reqres.in/api/users/2
    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Single<LoginResponse>

}
