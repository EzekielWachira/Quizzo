package com.ezzy.quizzo.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.navigation.utils.NavDestinations.Discover.DISCOVER
import com.ezzy.quizzo.navigation.utils.NavDestinations.Discover.DISCOVER_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS_DETAILS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTION_DETAILS
import com.ezzy.quizzo.ui.screens.discover.DiscoverScreen
import com.ezzy.quizzo.ui.screens.onboarding.OnboardingScreen
import com.ezzy.quizzo.ui.screens.sign_up.CreateAccountScreen
import com.ezzy.quizzo.ui.screens.sign_up.SignupStepsScreen
import com.ezzy.quizzo.ui.screens.top_authors.TopAuthorsScreen
import com.ezzy.quizzo.ui.screens.top_authors_details.TopAuthorsDetailsScreen
import com.ezzy.quizzo.ui.screens.top_collection_details.TopCollectionDetailsScreen
import com.ezzy.quizzo.ui.screens.top_collections.TopCollectionsScreen
import com.ezzy.quizzo.utils.slideInVerticallyEnterAnimation
import com.ezzy.quizzo.utils.slideOutVerticallyEnterAnimation


fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = NavDestinations.Auth.ONBOARDING,
        route = NavDestinations.Auth.AUTH_MAIN
    ) {

        composable(
            route = NavDestinations.Auth.ONBOARDING,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            OnboardingScreen(navController = navController)
        }

        composable(
            route = NavDestinations.Auth.SIGN_UP,
            enterTransition = { slideInVerticallyEnterAnimation() },
            exitTransition = { slideOutVerticallyEnterAnimation() }
        ) {
            SignupStepsScreen()
        }


    }
}