package com.example.galleryapp.data.remote

import com.example.galleryapp.data.models.ImagesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoints {

    @GET("api")
    suspend fun getImages(): Response<ImagesResponse>

}