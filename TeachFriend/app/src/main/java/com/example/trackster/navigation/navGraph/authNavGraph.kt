package com.example.trackster.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.trackster.navigation.AUTHENTICATION_ROUTE
import com.example.trackster.navigation.Screens
import com.example.trackster.userAuthentication.ui.LoginScreen
import com.example.trackster.userAuthentication.ui.SignupScreen
import com.example.trackster.userAuthentication.viewModel.AuthViewModel

fun NavGraphBuilder.authNavGraph(
    viewModel: AuthViewModel,
    navController: NavHostController

){
    navigation(
        startDestination = Screens.Login.route,
        route = AUTHENTICATION_ROUTE
    ){
        composable(
            route =  Screens.Login.route
        ){
            LoginScreen(viewModel,navController=navController)
        }

        composable(
            route =  Screens.Signup.route
        ){
            SignupScreen(navController = navController)
        }
    }
}