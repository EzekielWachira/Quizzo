package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS_DETAILS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTION_DETAILS
import com.ezzy.quizzo.ui.screens.top_authors.TopAuthorsScreen
import com.ezzy.quizzo.ui.screens.top_authors_details.TopAuthorsDetailsScreen
import com.ezzy.quizzo.ui.screens.top_collection_details.TopCollectionDetailsScreen
import com.ezzy.quizzo.ui.screens.top_collections.TopCollectionsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.topAuthorNavGraph(navController: NavController) {
    navigation(
        startDestination = TOP_AUTHORS,
        route = TOP_AUTHORS_MAIN
    ) {

        composable(
            route = TOP_AUTHORS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            TopAuthorsScreen(navController = navController)
        }

        composable(
            route = TOP_AUTHORS_DETAILS,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) { navBackStackEntry ->
            TopAuthorsDetailsScreen(
                navController = navController,
                authorStr = navBackStackEntry.arguments?.getString("author")
            )
        }

    }
}