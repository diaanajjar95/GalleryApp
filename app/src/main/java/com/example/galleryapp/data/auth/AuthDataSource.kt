package com.example.galleryapp.data.auth

interface AuthDataSource {

    suspend fun login(email: String, password: String): Boolean

}