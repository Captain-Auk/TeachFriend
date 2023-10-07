package com.example.trackster.userAuthentication.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class authRemoteDataSource @Inject constructor(){
        private val auth = FirebaseAuth.getInstance()

        suspend fun authenticateUser(username: String, password: String) {
                // authentication user logic
                val result = runCatching {
                        auth.signInWithEmailAndPassword(username, password).await()
                }
                if (result.isSuccess) {
                        // get the AuthResult object
                        val authResult = result.getOrNull()
                        // get the FirebaseUser object
                        val user = authResult?.user
                        // get the user's token
                        val token = user?.getIdToken(false)?.await()?.token
                        // save the token or use it as needed
                } else {
                        // handle failure
                       // log.e("Authentication failed",result.exceptionOrNull()?.message)
                        throw AuthenticationException("Authentication Failed: ${result.exceptionOrNull()?.message}")
                }
        }

        suspend fun login(): AuthToken {
                // login logic retrieve token
                val currentUser = auth.currentUser
                return AuthToken(currentUser?.uid ?: "")

        }
}