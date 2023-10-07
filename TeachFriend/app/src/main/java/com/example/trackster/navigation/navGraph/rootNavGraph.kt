package com.example.trackster.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.trackster.navigation.AUTHENTICATION_ROUTE
import com.example.trackster.navigation.ROOT_ROUTE
import com.example.trackster.userAuthentication.viewModel.AuthViewModel
import com.example.trackster.perfTracker.Stratum.viewModel.CreateStratumScreenViewModel


@Composable
fun NavGraphSetup(
    navController: NavHostController
) {
    val viewModel: AuthViewModel = viewModel()
    val homeViewModel: CreateStratumScreenViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = AUTHENTICATION_ROUTE,
        route = ROOT_ROUTE
    ) {


        homeNavGraph(homeViewModel, navController = navController)
        authNavGraph(viewModel, navController = navController)

    }
}

