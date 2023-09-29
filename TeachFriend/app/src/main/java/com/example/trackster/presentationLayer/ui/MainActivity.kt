package com.example.trackster.presentationLayer.ui

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier

import com.example.trackster.presentationLayer.screens.LoginScreen


import com.example.trackster.presentationLayer.ui.theme.TeachFriendTheme
import com.example.trackster.presentationLayer.viewModels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeachFriendTheme {

                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                    }
                }
            }
        }
    }


