package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTION_DETAILS
import com.ezzy.quizzo.ui.screens.top_collection_details.TopCollectionDetailsScreen
import com.ezzy.quizzo.ui.screens.top_collections.TopCollectionsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.topCollectionsNavGraph(navController: NavController) {
    navigation(
        startDestination = TOP_COLLECTIONS,
        route = TOP_COLLECTIONS_MAIN
    ) {

        composable(
            route = TOP_COLLECTIONS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            TopCollectionsScreen(navController = navController)
        }

        composable(route = TOP_COLLECTION_DETAILS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) { navBackStackEntry ->
            TopCollectionDetailsScreen(
                navController = navController,
                collection = navBackStackEntry.arguments?.getString("collection")
            )
        }

    }
}