package com.example.galleryapp

import android.app.Application
import com.example.galleryapp.data.auth.repoAuthModule
import com.example.galleryapp.data.remote.remoteModule
import com.example.galleryapp.ui.login.loginModule
import com.example.galleryapp.ui.register.registerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GalleryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GalleryApplication)
            modules(
                listOf(
                    remoteModule,
                    repoAuthModule,
                    loginModule,
                    registerModule
                )
            )
        }
    }

}