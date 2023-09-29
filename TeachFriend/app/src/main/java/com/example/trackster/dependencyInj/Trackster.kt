package com.example.trackster.dependencyInj

import android.app.Application
import com.example.trackster.DomainLayer.authRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Trackster : Application() {
}