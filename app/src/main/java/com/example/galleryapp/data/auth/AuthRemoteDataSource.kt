package com.example.galleryapp.data.auth

import com.example.galleryapp.data.remote.ApiDefaultResponse
import com.example.galleryapp.data.remote.ApiEndpoints

class AuthRemoteDataSource(
    private val apiEndpoints: ApiEndpoints
) : AuthDataSource {
    override suspend fun login(email: String, password: String): ApiDefaultResponse<Any> {
        TODO("Not yet implemented")
    }
}