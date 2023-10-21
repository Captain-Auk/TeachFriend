package com.example.trackster.userAuthentication.data


interface IAuthRepository {

    suspend fun authenticate(username: String, password: String): AuthToken

// throws AuthenticationException if credentials are invalid

}

data class User(val username: String, val password: String)

data class AuthToken(val token: String)