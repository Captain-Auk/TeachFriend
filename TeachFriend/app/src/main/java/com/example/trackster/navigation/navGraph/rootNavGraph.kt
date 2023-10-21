package com.example.trackster.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.trackster.navigation.ROOT_ROUTE
import com.example.trackster.navigation.LEARNER_GROUP_ROUTE
import com.example.trackster.userAuthentication.viewModel.AuthViewModel
import com.example.trackster.perfTracker.learnerGroup.viewModel.CreateLearnerGroupScreenViewModel


//@Composable
//fun NavGraphSetup(
//    navController: NavHostController,
//) {
//    val authViewModel: AuthViewModel = viewModel()
//    val createStratumScreenViewModel: CreateStratumScreenViewModel = viewModel()
//    NavHost(
//        navController = navController,
//        startDestination = AUTHENTICATION_ROUTE,
//        route = ROOT_ROUTE
//    ) {
//
//        StratumNavGraph(createStratumScreenViewModel, navController = navController)
//        homeNavGraph(createStratumScreenViewModel, navController = navController)
//        authNavGraph(authViewModel, navController = navController)
//
//    }
//}
@Composable
fun NavGraphSetup(
    navController: NavHostController,
) {
    val authViewModel: AuthViewModel = viewModel()
    val createLearnerGroupScreenViewModel: CreateLearnerGroupScreenViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = LEARNER_GROUP_ROUTE,
        route = ROOT_ROUTE
    ) {

        learnerGroupNavGraph(createLearnerGroupScreenViewModel, navController = navController)
        homeNavGraph(createLearnerGroupScreenViewModel, navController = navController)
        authNavGraph(authViewModel, navController = navController)

    }
}
