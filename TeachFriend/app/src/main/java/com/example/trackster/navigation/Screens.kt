package com.example.trackster.navigation


const val AUTHENTICATION_ROUTE = "authentication"
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"
const val LEARNER_GROUP_ROUTE = "stratum"
sealed class Screens(val route : String){
    object Login : Screens(route="Login_screen")
    object Signup : Screens(route="Signup_screen")
    object Home : Screens(route="Home_screen")
    object Course : Screens(route="Course_screen")
    object LearnerGroupHome : Screens(route="StratumHome_screen")
    object CreateLearnerGroup : Screens(route="CreateStratum_screen")

}