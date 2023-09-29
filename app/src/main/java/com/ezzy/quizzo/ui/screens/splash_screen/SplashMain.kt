package com.ezzy.quizzo.ui.screens.splash_screen

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.navigation.Screen
import com.ezzy.quizzo.navigation.graphs.appMainNavGraph
import com.ezzy.quizzo.navigation.graphs.authMainNavGraph
import com.ezzy.quizzo.navigation.graphs.splashNavGraph
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.navigation.utils.NavDestinations.MAIN_APP
import com.ezzy.quizzo.navigation.utils.NavDestinations.Splash.SPLASH_MAIN
import com.ezzy.quizzo.ui.screens.main.MainScreen


@Composable
fun SplashMain() {
    var navController = rememberNavController()

    Scaffold { paddingValues ->
        NavHost(
            navController.also { navController = it },
            startDestination = SPLASH_MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {
            splashNavGraph(navController)
            appMainNavGraph(navController)
            authMainNavGraph(navController)
        }
    }

}