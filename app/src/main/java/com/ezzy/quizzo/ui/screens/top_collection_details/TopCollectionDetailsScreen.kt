package com.ezzy.quizzo.ui.screens.top_collection_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.common.AppBarWithSearch
import com.ezzy.quizzo.ui.common.HeaderWithSort
import com.ezzy.quizzo.ui.common.QuizItem
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel
import com.ezzy.quizzo.ui.screens.top_collection_details.components.TopCard
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TopCollectionDetailsScreen(navController: NavController, collection: String?) {
    val systemUiController = rememberSystemUiController()
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isDarkModeEnabled by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)
    val useDarkIcons = !isDarkModeEnabled

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

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                    TopCard(Modifier.fillMaxWidth(), height = 200.dp)
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                    HeaderWithSort(
                        title = "245 Quizzo",
                        modifier = Modifier.fillMaxWidth(),
                        onSortClick = {})
                }
            }

            items(quizzes) { quiz ->
                QuizItem(quiz = quiz, modifier = Modifier.fillMaxWidth(),
                    onClick = {})
            }

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