package com.example.teachfriend

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier
import com.example.teachfriend.Screens.LoginScreen


import com.example.teachfriend.ui.theme.TeachFriendTheme



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



