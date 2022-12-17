package com.example.galleryapp.data.images

import com.example.galleryapp.data.models.ImagesResponse
import com.example.galleryapp.data.remote.ApiDefaultResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImagesRepository(
    private val remoteDataSource: ImagesDataSource
) : ImagesDataSource {

    override suspend fun getImages(): ApiDefaultResponse<ImagesResponse> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getImages()
        }
    }

}