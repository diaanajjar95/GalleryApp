package com.example.galleryapp.data.auth

class AuthRemoteDataSource(
    private val fakeAuthService: FakeAuthService
) : AuthDataSource {
    override suspend fun login(email: String, password: String): Boolean {
        return fakeAuthService.login(email, password)
    }
}