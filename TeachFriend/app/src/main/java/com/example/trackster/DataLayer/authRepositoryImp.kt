package com.example.trackster.DataLayer

import com.example.trackster.DomainLayer.authRepository
import com.example.trackster.DomainLayer.AuthToken
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton


class authRepositoryImp @Inject constructor(
    var remoteDataSource: RemoteDataSource): authRepository {
    override suspend fun authenticate(username: String, password: String): AuthToken {

        Log.d("authRepository", "USER IS AUTHENTICATED")
        // Authenticate user
        remoteDataSource.authenticateUser(username, password)
        Log.d("authRepository", "authentication process done")
        // Return login token
        return remoteDataSource.login()

    }
    }
