package com.example.trackster.uiHelpers

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel


import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trackster.navigation.navGraph.NavGraphSetup


import com.example.trackster.uiHelpers.theme.TeachFriendTheme
import com.example.trackster.userAuthentication.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeachFriendTheme {
                navController = rememberNavController()
                NavGraphSetup(navController = navController)
                }
            }
        }
    }


