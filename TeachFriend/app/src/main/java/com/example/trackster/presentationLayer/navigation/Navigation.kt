package com.example.trackster.presentationLayer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trackster.presentationLayer.screens.HomeScreen
import com.example.trackster.presentationLayer.screens.LoginScreen

//a sealed class called Screen that represents the different screens in your app.
// Each screen has a name and a route
sealed class Screen(val name: String, val route: String) {
    object Login : Screen("Login", "login")
    object Signup : Screen("Signup", "signup")
    object Home : Screen("Home", "home")
}

//a composable function called Navigation that takes a NavHostController as a parameter
// and returns a NavHost with the composable destinations
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) { LoginScreen() }
     //   composable(Screen.Signup.route) { SignupScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
    }
}

