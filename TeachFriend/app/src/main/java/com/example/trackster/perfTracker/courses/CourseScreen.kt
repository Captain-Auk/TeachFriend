package com.example.trackster.perfTracker.courses


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.teachfriend.R
import com.example.trackster.navigation.Screens
import com.example.trackster.uiHelpers.GeneralButton


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen( navController : NavController) {


    var isLogoutButtonClicked = false

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
                Text(text = "Welcome to the Course Screen")
                Log.d("CourseScreen", "I am in homeScreen")
                Spacer(modifier = Modifier.height(16.dp))
                GeneralButton(
                    text = "Logout",
                    onClick = {
                        if (!isLogoutButtonClicked) {
                            isLogoutButtonClicked = true
                            navController.navigate(Screens.Login.route)

                        }
                    }
                )
                Log.d("CourseScreen", "I am pass the logout button in homeScreen")
            }
        }
    }
}