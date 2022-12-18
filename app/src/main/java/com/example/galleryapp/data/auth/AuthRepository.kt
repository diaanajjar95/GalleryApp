package com.example.galleryapp.data.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(
    private val remoteDataSource: AuthDataSource
) : AuthDataSource {

    override suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            remoteDataSource.login(email, password)
        }
    }

    override suspend fun signUp(email: String, age: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            remoteDataSource.signUp(email, age, password)
        }
    }

}