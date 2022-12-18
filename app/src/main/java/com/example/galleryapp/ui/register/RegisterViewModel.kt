package com.example.galleryapp.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.auth.AuthDataSource
import com.example.galleryapp.isValidEmail
import com.example.galleryapp.isValidPassword
import com.example.galleryapp.ui.base.BaseViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: AuthDataSource
) : BaseViewModel() {

    private val _errorMessage = LiveEvent<Pair<EnumUiFields, String>>()
    val errorMessage: LiveData<Pair<EnumUiFields, String>> = _errorMessage

    private val _navigate = LiveEvent<Boolean>()
    val navigate: LiveData<Boolean> = _navigate

    fun signUp(email: String, age: String, password: String) {
        if (email.isEmpty()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_EMAIL, "email is required")
            return
        }

        if (!email.isValidEmail()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_EMAIL, "The email must be valid")
            return
        }

        if (age.isEmpty()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_AGE, "age is required")
            return
        }

        if (age.toInt() !in 18..99) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_AGE, "The age must be limited between 18 and 99 years old")
            return
        }

        if (password.isEmpty()) {
            _errorMessage.value =
                Pair(EnumUiFields.FIELD_PASSWORD, "password is required")
            return
        }

        if (!password.isValidPassword()) {
            _errorMessage.value =
                Pair(EnumUiFields.FIELD_PASSWORD, "The password must be between 6 and 12 characters long")
            return
        }

        onStartLoading()
        viewModelScope.launch {
            val isSuccess = repository.signUp(email, age, password)
            if (isSuccess) {
                _navigate.value = true
                onLoadSuccess()
            } else {
                onLoadFailure("something went wrong")
            }
        }
    }

    enum class EnumUiFields {
        FIELD_EMAIL,
        FIELD_PASSWORD,
        FIELD_AGE,
    }

}