package com.example.galleryapp.ui.register

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registerModule = module {
    viewModel { RegisterViewModel(get()) }
}