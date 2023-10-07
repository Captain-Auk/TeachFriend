package com.example.trackster.userAuthentication.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.res.stringResource
import com.example.teachfriend.R
import com.example.trackster.uiHelpers.GeneralButton
import androidx.compose.foundation.layout.*
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trackster.navigation.Screens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController : NavController) {
    //val viewModel: ViewModel = viewModel()
    Log.d("SignupScreen", "I have entered SignupScreen")
    MaterialTheme {
        Scaffold(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(id = R.string.app_name)) },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(id = R.string.menu_name)
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Welcome to the  Trackster, Join us")
                Spacer(modifier = Modifier.height(16.dp))
                Log.d("SignupScreen", "I am routing to HomeScreen")
                GeneralButton(
                    text = "Home",
                    onClick = {

                        navController.navigate(route = Screens.Home.route)
                    }
                )

            }
        }
    }
}
