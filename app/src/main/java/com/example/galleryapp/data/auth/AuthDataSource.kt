package com.example.galleryapp.data.auth

interface AuthDataSource {

    suspend fun login(email: String, password: String): Boolean

    suspend fun signUp(email: String, age: String, password: String): Boolean

}