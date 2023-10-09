package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations.CollectionDetails.COLLECTION_DETAILS
import com.ezzy.quizzo.navigation.utils.NavDestinations.CollectionDetails.COLLECTION_DETAILS_MAIN
import com.ezzy.quizzo.ui.screens.collection_details.CollectionDetailsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.collectionDetailsNavGraph(
    navController: NavController,
    isSystemInDarkTheme: Boolean
) {
    navigation(
        startDestination = COLLECTION_DETAILS,
        route = COLLECTION_DETAILS_MAIN
    ) {

        composable(
            route = COLLECTION_DETAILS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            CollectionDetailsScreen(
                navController = navController,
                isSystemInDarkTheme = isSystemInDarkTheme
            )
        }


    }
}