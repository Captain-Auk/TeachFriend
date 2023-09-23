package com.example.trackster.dataLayer

class AuthRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : AuthRepository {

    override suspend fun authenticate(username: String, password: String): AuthToken {

        // Authenticate user
        remoteDataSource.authenticateUser(username, password)

        // Return login token
        return remoteDataSource.login()
    }
    }
