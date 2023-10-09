package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.NOTIFICATION_SETTINGS
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.PREMIUM
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.SETTINGS
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.SETTINGS_MAIN
import com.ezzy.quizzo.ui.screens.notification_settings.NotificationSettingsScreenRoute
import com.ezzy.quizzo.ui.screens.premium.PremiumScreen
import com.ezzy.quizzo.ui.screens.settings.SettingsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.settingsNavGraph(navController: NavController, isSystemInDarkTheme: Boolean) {
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
        composable(
            route = NOTIFICATION_SETTINGS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            NotificationSettingsScreenRoute(
                isSystemInDarkTheme = isSystemInDarkTheme,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = PREMIUM,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            PremiumScreen(
                isSystemInDarkTheme = isSystemInDarkTheme,
                onNavigateBack = {
                    navController.popBackStack()
                },
                navController = navController
            )
        }



    }
}