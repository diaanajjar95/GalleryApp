package com.example.galleryapp

import com.example.galleryapp.ui.base.binding.BindingAdapters
import com.example.galleryapp.ui.base.binding.BindingAdaptersImpl
import org.koin.dsl.module

val appModule = module {

    single<BindingAdapters> {
        BindingAdaptersImpl()
    }

}