package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.Screen
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.AUTH
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.AUTHENTICATION
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.REGISTRATION
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.REGISTRATION_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.MAIN_APP
import com.ezzy.quizzo.ui.screens.auth.AuthMainScreen
import com.ezzy.quizzo.ui.screens.main.MainScreen
import com.ezzy.quizzo.ui.screens.sign_up.SignupStepsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.registrationNavGraph(navController: NavController) {
    navigation(
        route = REGISTRATION_MAIN,
        startDestination = REGISTRATION
    ) {
        composable(route = REGISTRATION,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }) {
            SignupStepsScreen()
        }
    }
}