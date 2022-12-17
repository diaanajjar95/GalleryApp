package com.example.galleryapp.data.auth

import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val KOIN_NAME_AUTH_REMOTE_DATA_SOURCE = "KOIN_NAME_AUTH_REMOTE_DATA_SOURCE"

val repoAuthModule = module {

    single<AuthDataSource> {
        AuthRepository(get(named(KOIN_NAME_AUTH_REMOTE_DATA_SOURCE)))
    }

    single<AuthDataSource>(named(KOIN_NAME_AUTH_REMOTE_DATA_SOURCE)) {
        AuthRemoteDataSource(get())
    }

}