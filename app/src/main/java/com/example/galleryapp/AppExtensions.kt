package com.example.galleryapp

import android.util.Patterns

fun String?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String?.isValidPassword() = (this?.length ?: 0) in 6..12
