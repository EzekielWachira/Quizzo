package com.ezzy.quizzo.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations.SignupSteps.ACCOUNT_TYPE
import com.ezzy.quizzo.navigation.utils.NavDestinations.SignupSteps.SIGNUP_STEPS
import com.ezzy.quizzo.navigation.utils.NavDestinations.SignupSteps.WORKPLACE
import com.ezzy.quizzo.ui.screens.sign_up.AccountTypeScreen
import com.ezzy.quizzo.ui.screens.sign_up.WorkPlaceScreen

fun NavGraphBuilder.signUpStepsNavGraph(navController: NavController) {

    val enterTransitionAnimation = slideInVertically(
        animationSpec = tween(700),
        initialOffsetY = { it }
    )

    val exitTransitionAnimation = slideOutVertically(
        animationSpec = tween(700),
        targetOffsetY = { it }
    )

    navigation(
        startDestination = ACCOUNT_TYPE,
        route = SIGNUP_STEPS
    ) {

        composable(
            route = ACCOUNT_TYPE,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            AccountTypeScreen(navController = navController)
        }

        composable(route = WORKPLACE,
            enterTransition = { enterTransitionAnimation },
            exitTransition = { exitTransitionAnimation }
        ) {
            WorkPlaceScreen(navController = navController)
        }

    }
}