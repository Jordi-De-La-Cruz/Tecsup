package com.example.tecsup.userlist

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("data") val users: List<User>
)
