package com.example.trackster.dataLayer

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException

class RemoteDataSource {
        private val auth = FirebaseAuth.getInstance()

        suspend fun authenticateUser(username: String, password: String) {
                // authentication user logic
                auth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener{ task->
                                if (!task.isSuccessful){
                                        throw AuthenticationException("Authentication Failed")
                                }
                        }

        }

        suspend fun login(): AuthToken {
                // login logic retrieve token
                val currentUser = auth.currentUser
                return AuthToken(currentUser?.uid ?: "")

        }
}