package com.ezzy.quizzo.navigation.graphs

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.Screen
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.navigation.utils.NavDestinations.Main.MAIN
import com.ezzy.quizzo.ui.screens.create.CreateScreen
import com.ezzy.quizzo.ui.screens.followers.FollowersScreen
import com.ezzy.quizzo.ui.screens.home.HomeScreen
import com.ezzy.quizzo.ui.screens.join.JoinScreen
import com.ezzy.quizzo.ui.screens.library.LibraryScreen
import com.ezzy.quizzo.ui.screens.profile.ProfileScreen
import com.ezzy.quizzo.ui.screens.stats.StatsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation

fun NavGraphBuilder.mainNavGraph(navController: NavController, isSystemInDarkTheme: Boolean) {

    val enterTransitionAnimation = slideInVertically(
        animationSpec = tween(700),
        initialOffsetY = { it }
    )

    val exitTransitionAnimation = slideOutVertically(
        animationSpec = tween(700),
        targetOffsetY = { it }
    )

    navigation(
        startDestination = Screen.Home.route,
        route = MAIN
    ) {

        composable(
            route = Screen.Home.route,
            enterTransition = {
                enterTransitionAnimation
            },
            exitTransition = { exitTransitionAnimation }
        ) {
            HomeScreen(navController = navController, isSystemInDarkTheme = isSystemInDarkTheme)
        }

        composable(route = Screen.Libary.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            LibraryScreen(navController = navController)
        }

        composable(route = Screen.Join.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            JoinScreen(navController = navController)
        }

        composable(route = Screen.Create.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            CreateScreen(navController = navController)
        }

        composable(route = Screen.Profile.route,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            ProfileScreen(navController = navController)
        }

        composable(
            route = NavDestinations.Settings.STATS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            StatsScreen(
                navController = navController,
                isSystemInDarkTheme = isSystemInDarkTheme
            )
        }

        composable(
            route = NavDestinations.Settings.FOLLOWERS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            FollowersScreen(
                navController = navController,
                isSystemInDarkTheme = isSystemInDarkTheme
            )
        }
    }
}