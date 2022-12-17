package com.example.galleryapp.data.auth

import com.example.galleryapp.data.remote.ApiDefaultResponse

interface AuthDataSource {

    suspend fun login(email: String, password: String): ApiDefaultResponse<Any>

}