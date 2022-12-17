package com.example.galleryapp.data.remote

import com.example.galleryapp.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal const val KOIN_NAME_BASE_URL = "KOIN_NAME_BASE_URL"

val remoteModule = module {

    single(named(KOIN_NAME_BASE_URL)) {
        BuildConfig.BASE_URL
    }

    single<Moshi> {
        Moshi.Builder()
            .build()
    }

    single {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.connectTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logger)
        }
        builder.build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named(KOIN_NAME_BASE_URL)))
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .client(get())
            .build()
    }

    single<ApiEndpoints> {
        get<Retrofit>().create(ApiEndpoints::class.java)
    }

}