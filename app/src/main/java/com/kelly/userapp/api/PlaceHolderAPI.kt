package com.kelly.userapp.api

import com.kelly.userapp.models.User
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderAPI {

    @GET("users")
    suspend fun getUsers(): List<User>
}