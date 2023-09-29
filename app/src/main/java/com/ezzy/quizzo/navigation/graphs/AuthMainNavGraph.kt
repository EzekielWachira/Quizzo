package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.Screen
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.AUTH
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.AUTHENTICATION
import com.ezzy.quizzo.navigation.utils.NavDestinations.MAIN_APP
import com.ezzy.quizzo.ui.screens.auth.AuthMainScreen
import com.ezzy.quizzo.ui.screens.main.MainScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.authMainNavGraph(navController: NavController) {
    navigation(
        route = AUTH,
        startDestination = AUTHENTICATION
    ) {
        composable(route = AUTHENTICATION,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }) {
            AuthMainScreen()
        }
    }
}