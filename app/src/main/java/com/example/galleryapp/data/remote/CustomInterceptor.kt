package com.example.galleryapp.data.remote

import com.example.galleryapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val httpUrl = original.url
        val newHttpUrl =
            httpUrl.newBuilder().addQueryParameter("key", BuildConfig.API_KEY).build()
        val newRequestBuilder = original.newBuilder().url(newHttpUrl)
        val newRequest = newRequestBuilder.build()
        return chain.proceed(newRequest)
    }
}