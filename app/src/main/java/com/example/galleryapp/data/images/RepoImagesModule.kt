package com.example.galleryapp.data.images

import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val KOIN_NAME_IMAGES_REMOTE_DATA_SOURCE = "KOIN_NAME_IMAGES_REMOTE_DATA_SOURCE"

val repoImagesModule = module {

    single<ImagesDataSource> {
        ImagesRepository(get(named(KOIN_NAME_IMAGES_REMOTE_DATA_SOURCE)))
    }

    single<ImagesDataSource>(named(KOIN_NAME_IMAGES_REMOTE_DATA_SOURCE)) {
        ImagesRemoteDataSource(get())
    }

}