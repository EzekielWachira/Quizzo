package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.Screen
import com.ezzy.quizzo.navigation.utils.NavDestinations.MAIN_APP
import com.ezzy.quizzo.ui.screens.main.MainScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.appMainNavGraph(navController: NavController) {
    navigation(
        route = MAIN_APP,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }) {
            MainScreen()
        }
    }
}