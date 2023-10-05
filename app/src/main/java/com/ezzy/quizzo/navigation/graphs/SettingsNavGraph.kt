package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.AUTH_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.ONBOARDING
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.SIGN_UP
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.SETTINGS
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.SETTINGS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.Splash.SPLASH
import com.ezzy.quizzo.navigation.utils.NavDestinations.Splash.SPLASH_MAIN
import com.ezzy.quizzo.ui.screens.onboarding.OnboardingScreen
import com.ezzy.quizzo.ui.screens.settings.SettingsScreen
import com.ezzy.quizzo.ui.screens.sign_up.CreateAccountScreen
import com.ezzy.quizzo.ui.screens.splash_screen.SplashScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.settingsNavGraph(navController: NavController) {
    navigation(
        startDestination = SETTINGS,
        route = SETTINGS_MAIN
    ) {

        composable(
            route = SETTINGS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            SettingsScreen(navController = navController)
        }



    }
}