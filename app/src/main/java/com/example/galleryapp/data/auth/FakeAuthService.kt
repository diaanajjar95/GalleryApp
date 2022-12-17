package com.example.galleryapp.data.auth

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class FakeAuthService {

    suspend fun login(email: String, password: String): Boolean {
        runBlocking {
            delay(3000)
        }
        return true
    }

}