package com.example.trackster.userAuthentication.data

import android.app.Application
import com.google.firebase.FirebaseApp

class LoginFlowApp : Application(){
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}