package com.kelly.userapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitProvider {

    private val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val placeHolderAPI = retrofit.create(PlaceHolderAPI::class.java)
}