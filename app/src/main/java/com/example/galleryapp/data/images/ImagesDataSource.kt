package com.example.galleryapp.data.images

import com.example.galleryapp.data.models.ImagesResponse
import com.example.galleryapp.data.remote.ApiDefaultResponse

interface ImagesDataSource {

    suspend fun getImages(): ApiDefaultResponse<ImagesResponse>

}