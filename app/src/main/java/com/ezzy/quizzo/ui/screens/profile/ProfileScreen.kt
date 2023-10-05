package com.ezzy.quizzo.ui.screens.profile

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.navigation.utils.NavDestinations.Settings.SETTINGS_MAIN
import com.ezzy.quizzo.ui.common.CustomPadding
import com.ezzy.quizzo.ui.common.CustomTab
import com.ezzy.quizzo.ui.common.HeaderWithSort
import com.ezzy.quizzo.ui.common.LogoAppBarWithThreeActions
import com.ezzy.quizzo.ui.common.QuizItem
import com.ezzy.quizzo.ui.screens.home.authors2
import com.ezzy.quizzo.ui.screens.home.collections
import com.ezzy.quizzo.ui.screens.home.components.CollectionItem
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel
import com.ezzy.quizzo.ui.screens.top_authors.components.AuthorItem
import com.ezzy.quizzo.ui.screens.top_authors_details.components.TopAuthorStats
import com.ezzy.quizzo.ui.screens.top_collection_details.components.TopCard
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ProfileScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isDarkModeEnabled by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)
    val useDarkIcons = !isDarkModeEnabled

    val tabTitles = listOf(
        stringResource(id = R.string.app_name),
        stringResource(id = R.string.collections),
        stringResource(R.string.about)
    )

    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }


    Scaffold(
        topBar = {
            LogoAppBarWithThreeActions(
                icon1 = R.drawable.send,
                icon2 = R.drawable.stats_1,
                icon3 = R.drawable.settings,
                title = stringResource(id = R.string.profile),
                onAction1Click = {},
                onAction2Click = {},
                onAction3Click = { navController.navigate(SETTINGS_MAIN) }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            item {
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                TopCard(Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                AuthorItem(author = authors2[0], modifier = Modifier.fillMaxWidth(),
                    onEditClick = {})
                TopAuthorStats(Modifier.fillMaxWidth())
                CustomTab(
                    selectedIndex = selectedTabIndex,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { index -> selectedTabIndex = index },
                    tabTitles = tabTitles
                )

                if (selectedTabIndex == 0 || selectedTabIndex == 1)
                    HeaderWithSort(
                        title = when (selectedTabIndex) {
                            0 -> "45 Quizzo"
                            1 -> "30 Collections"
                            else -> ""
                        }
                    )
            }

            when (selectedTabIndex) {
                0 -> {
                    items(quizzes.take(5)) { quiz ->
                        QuizItem(quiz = quiz, modifier = Modifier.fillMaxWidth(),
                            onClick = {})
                    }
                }

                1 -> {
                    items(collections) { collection ->
                        CollectionItem(collection = collection,
                            modifier = Modifier.fillMaxWidth(),
                            height = 150.dp,
                            onClick = { }
                        )
                    }
                }

                2 -> {
                    item {
                        CustomPadding(
                            verticalPadding = DpDimensions.Small,
                            horizontalPadding = DpDimensions.Smallest
                        ) {
                            Text(
                                text = stringResource(id = R.string.dummy_text),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.inversePrimary,
                                textAlign = TextAlign.Justify
                            )
                        }
                    }
                }
            }


            item {
                Column {
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                }
            }

        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenPreview() {
    QuizzoTheme {
        ProfileScreen(rememberNavController())
    }
}