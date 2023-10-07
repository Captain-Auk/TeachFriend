package com.example.trackster.uiHelpers

import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trackster.navigation.navGraph.NavGraphSetup


import com.example.trackster.uiHelpers.theme.TeachFriendTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            Log.d("MyApp", "onCreate() called");

        setContent {
            TeachFriendTheme {
                navController = rememberNavController()
                NavGraphSetup(navController = navController)
                /*Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                    }*/
                }
            }
        }
    }


