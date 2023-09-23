package com.example.trackster.dataLayer



interface AuthRepository {

    suspend fun authenticate(username: String, password: String): AuthToken

// throws AuthenticationException if credentials are invalid

}

data class User(val username: String, val password: String)

data class AuthToken(val token: String)