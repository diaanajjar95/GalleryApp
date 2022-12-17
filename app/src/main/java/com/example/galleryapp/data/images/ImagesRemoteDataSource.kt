package com.example.galleryapp.data.images

import com.example.galleryapp.data.models.ImagesResponse
import com.example.galleryapp.data.remote.ApiDefaultResponse
import com.example.galleryapp.data.remote.ApiEndpoints

class ImagesRemoteDataSource(
    private val apiEndpoints: ApiEndpoints
) : ImagesDataSource {

    override suspend fun getImages(): ApiDefaultResponse<ImagesResponse> {
        return try {
            ApiDefaultResponse.create(apiEndpoints.getImages())
        } catch (e: Exception) {
            ApiDefaultResponse.create(e)
        }
    }

}