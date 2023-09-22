package com.ezzy.quizzo.ui.screens.sign_up

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.navigation.graphs.signUpStepsNavGraph
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.ui.screens.sign_up.components.AppBarWithProgress
import com.ezzy.quizzo.ui.screens.sign_up.state.ProgressState
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SignupStepsScreen() {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val navController = rememberNavController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = { AppBarWithProgress(progressState = ProgressState()) }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = NavDestinations.SignupSteps.SIGNUP_STEPS,
            modifier = Modifier.padding(paddingValues)
        ) {
            signUpStepsNavGraph(navController)
        }


    }

}

@Preview
@Composable
fun SignupStepsScreenPreview() {
    QuizzoTheme {
        SignupStepsScreen()
    }
}