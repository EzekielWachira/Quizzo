package com.ezzy.quizzo.ui.screens.top_collection_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.AppBarWithSearch
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TopCollectionDetailsScreen(navController: NavController, collection: String?) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            AppBarWithSearch(
                title = collection ?: stringResource(R.string.collection_details),
                backIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackClick = { navController.popBackStack() },
                onSearchClick = { }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
        ) {

        }

    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TopCollectionDetailsScreenPreview() {
    QuizzoTheme {
        TopCollectionDetailsScreen(rememberNavController(), "Education")
    }
}