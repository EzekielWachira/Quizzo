package com.ezzy.quizzo.ui.screens.auth

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.navigation.graphs.appMainNavGraph
import com.ezzy.quizzo.navigation.graphs.authNavGraph
import com.ezzy.quizzo.navigation.graphs.registrationNavGraph
import com.ezzy.quizzo.navigation.utils.NavDestinations


@Composable
fun AuthMainScreen() {
    var navController = rememberNavController()
    Scaffold { paddingValues ->
        NavHost(
            navController.also { navController = it },
            startDestination = NavDestinations.Auth.AUTH_MAIN,
            modifier = Modifier.padding(paddingValues)
        ) {
            authNavGraph(navController)
//            registrationNavGraph(navController)
            appMainNavGraph(navController)
        }
    }
}