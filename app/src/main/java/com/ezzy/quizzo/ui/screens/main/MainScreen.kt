package com.ezzy.quizzo.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.navigation.BottomNavBar
import com.ezzy.quizzo.navigation.Screen
import com.ezzy.quizzo.navigation.graphs.authMainNavGraph
import com.ezzy.quizzo.navigation.graphs.collectionDetailsNavGraph
import com.ezzy.quizzo.navigation.graphs.discoverNavGraph
import com.ezzy.quizzo.navigation.graphs.findFriendsNavGraph
import com.ezzy.quizzo.navigation.graphs.mainNavGraph
import com.ezzy.quizzo.navigation.graphs.settingsNavGraph
import com.ezzy.quizzo.navigation.graphs.topAuthorNavGraph
import com.ezzy.quizzo.navigation.graphs.topCollectionsNavGraph
import com.ezzy.quizzo.navigation.utils.NavDestinations.Main.MAIN
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel

@Composable
fun MainScreen() {

    var bottomBarVisible by rememberSaveable {
        mutableStateOf(false)
    }

    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isSystemInDarkTheme by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(
        initialValue = false
    )
    val useDarkIcons = !isSystemInDarkTheme

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    bottomBarVisible = when (navBackStackEntry?.destination?.route) {
        Screen.Home.route -> true
        Screen.Libary.route -> true
        Screen.Join.route -> true
        Screen.Create.route -> true
        Screen.Profile.route -> true
        else -> false
    }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                visible = bottomBarVisible,
                isSystemInDarkMode = isSystemInDarkTheme
            )
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {

            mainNavGraph(navController, isSystemInDarkTheme)
            topCollectionsNavGraph(navController)
            topAuthorNavGraph(navController)
            discoverNavGraph(navController)
            findFriendsNavGraph(navController)
            authMainNavGraph(navController)
            settingsNavGraph(navController, isSystemInDarkTheme)
            collectionDetailsNavGraph(navController, isSystemInDarkTheme)

        }
    }

}