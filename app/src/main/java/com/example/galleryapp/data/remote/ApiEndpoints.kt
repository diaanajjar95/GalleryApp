package com.example.galleryapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoints {

    @GET("api")
    suspend fun getProducts(): Response<Any>

}