package com.example.galleryapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.data.auth.AuthDataSource
import com.example.galleryapp.isValidEmail
import com.example.galleryapp.isValidPassword
import com.example.galleryapp.ui.base.BaseViewModel
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: AuthDataSource
) : BaseViewModel() {

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
            _errorMessage.value = Pair(EnumUiFields.FIELD_EMAIL, "The email must be valid")
            return
        }

        if (password.isEmpty()) {
            _errorMessage.value = Pair(EnumUiFields.FIELD_PASSWORD, "password is required")
            return
        }

        if (!password.isValidPassword()) {
            _errorMessage.value = Pair(
                EnumUiFields.FIELD_PASSWORD,
                "The password must be between 6 and 12 characters long"
            )
            return
        }

        onStartLoading()
        viewModelScope.launch {
            val isSuccess = repository.login(email, password)
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
    }

}