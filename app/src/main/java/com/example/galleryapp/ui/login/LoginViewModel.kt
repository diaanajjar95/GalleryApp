package com.example.galleryapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.auth.AuthDataSource
import com.example.galleryapp.isValidEmail
import com.example.galleryapp.isValidPassword
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthDataSource
) : ViewModel() {

    private val _loading = LiveEvent<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _message = LiveEvent<String>()
    val message: LiveData<String> = _message

    private val _errorMessage = LiveEvent<Pair<EnumUiFields, String>>()
    val errorMessage: LiveData<Pair<EnumUiFields, String>> = _errorMessage

    private val _navigate = LiveEvent<Boolean>()
    val navigate: LiveData<Boolean> = _navigate

    fun login(email: String, password: String) {
        if (email.isEmpty()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_EMAIL, "email is required")
            return
        }

        if (!email.isValidEmail()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_EMAIL, "invalid email")
            return
        }

        if (password.isEmpty()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_PASSWORD, "password is required")
            return
        }

        if (!password.isValidPassword()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_PASSWORD, "invalid password")
            return
        }

        _loading.value = true
        viewModelScope.launch {
            val isSuccess = repository.login(email, password)
            if (isSuccess) {
                _navigate.value = true
                _loading.value = false
            } else {
                _message.value = "something went wrong"
                _loading.value = false
            }
        }
    }

    enum class EnumUiFields {
        FIELD_EMAIL,
        FIELD_PASSWORD,
    }

}