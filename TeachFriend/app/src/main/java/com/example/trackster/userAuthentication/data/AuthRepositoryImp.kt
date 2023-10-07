package com.example.trackster.userAuthentication.data

import android.util.Log
import javax.inject.Inject


class authRepositoryImp @Inject constructor(
    var authRemoteDataSource: authRemoteDataSource
): authRepository {
    override suspend fun authenticate(username: String, password: String): AuthToken {

        Log.d("authRepository", "USER IS AUTHENTICATED")
        // Authenticate user
        authRemoteDataSource.authenticateUser(username, password)
        Log.d("authRepository", "authentication process done")
        // Return login token
        return authRemoteDataSource.login()

    }
    }
