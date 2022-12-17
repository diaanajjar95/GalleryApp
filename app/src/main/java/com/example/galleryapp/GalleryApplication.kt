package com.example.galleryapp

import android.app.Application
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.example.galleryapp.data.auth.repoAuthModule
import com.example.galleryapp.data.images.repoImagesModule
import com.example.galleryapp.data.remote.remoteModule
import com.example.galleryapp.ui.base.binding.BindingAdapters
import com.example.galleryapp.ui.home.homeModule
import com.example.galleryapp.ui.login.loginModule
import com.example.galleryapp.ui.register.registerModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GalleryApplication : Application(), DataBindingComponent {

    private val appBindingAdapters: BindingAdapters by inject()

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(this)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GalleryApplication)
            modules(
                listOf(
                    appModule,
                    remoteModule,
                    repoAuthModule,
                    loginModule,
                    registerModule,
                    homeModule,
                    repoImagesModule
                )
            )
        }
    }

    override fun getBindingAdapters(): BindingAdapters {
        return appBindingAdapters
    }

}