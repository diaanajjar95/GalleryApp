package com.example.galleryapp

interface AppListener {

    fun showProgress()
    fun hideProgress()
    fun showMessage(message: String?)

}