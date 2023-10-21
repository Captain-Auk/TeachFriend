package com.example.trackster.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.trackster.navigation.LEARNER_GROUP_ROUTE
import com.example.trackster.navigation.Screens
import com.example.trackster.perfTracker.learnerGroup.ui.CreateLearnerGroupScreen
import com.example.trackster.perfTracker.learnerGroup.ui.learnerGroupHomeScreen
import com.example.trackster.perfTracker.learnerGroup.viewModel.CreateLearnerGroupScreenViewModel

fun NavGraphBuilder.learnerGroupNavGraph(
    createLearnerGroupScreenViewModel: CreateLearnerGroupScreenViewModel,
    navController: NavHostController
){
    navigation(
        startDestination = Screens.LearnerGroupHome.route,
        route = LEARNER_GROUP_ROUTE
    ){
        composable(
            route =  Screens.LearnerGroupHome.route
        ){
            learnerGroupHomeScreen(
                viewModel = createLearnerGroupScreenViewModel,
                navController = navController
            )
        }
        composable(
            route =  Screens.CreateLearnerGroup.route
        ){
            CreateLearnerGroupScreen(
                viewModel = createLearnerGroupScreenViewModel,
                navController = navController
            )
        }
    }
}