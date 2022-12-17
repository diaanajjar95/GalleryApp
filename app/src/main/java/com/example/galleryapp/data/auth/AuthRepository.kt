package com.example.galleryapp.data.auth

import com.example.galleryapp.data.remote.ApiDefaultResponse

class AuthRepository(
    private val remoteDataSource: AuthDataSource
) : AuthDataSource {
    override suspend fun login(email: String, password: String): ApiDefaultResponse<Any> {
        TODO("Not yet implemented")
    }
}