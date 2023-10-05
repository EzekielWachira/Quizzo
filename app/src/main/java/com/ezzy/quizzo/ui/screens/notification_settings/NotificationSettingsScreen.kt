package com.ezzy.quizzo.ui.screens.notification_settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.CommonAppBarWithTitle
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NotificationSettingsScreen(navController: NavController, isSystemInDarkTheme: Boolean) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            CommonAppBarWithTitle(
                title = stringResource(id = R.string.notifications),
                backIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
        ) {

        }

    }

}