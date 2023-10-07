package com.example.trackster.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.trackster.navigation.HOME_ROUTE
import com.example.trackster.navigation.Screens
import com.example.trackster.perfTracker.courses.CourseScreen
import com.example.trackster.perfTracker.Stratum.ui.CreateStratumScreen
import com.example.trackster.perfTracker.Stratum.viewModel.CreateStratumScreenViewModel


fun NavGraphBuilder.homeNavGraph(
    homeViewModel: CreateStratumScreenViewModel,
    navController: NavHostController
){
    navigation(
        startDestination = Screens.Home.route,
        route = HOME_ROUTE
    ){
        composable(
            route =  Screens.Home.route
        ){
            CreateStratumScreen(homeViewModel,navController = navController)
        }
        composable(
            route =  Screens.Course.route
        ){
            CourseScreen(navController = navController)
        }
    }

}