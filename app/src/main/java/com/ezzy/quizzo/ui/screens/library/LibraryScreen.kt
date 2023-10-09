package com.ezzy.quizzo.ui.screens.library

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.navigation.utils.NavDestinations.CollectionDetails.COLLECTION_DETAILS_MAIN
import com.ezzy.quizzo.ui.common.LogoAppBarWithTwoActions
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LibraryScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isDarkModeEnabled by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)
    val useDarkIcons = !isDarkModeEnabled

    var tabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(R.string.my_quizzo),
        stringResource(R.string.favorites),
        stringResource(R.string.collaboration)
    )

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }


    Scaffold(
        topBar = {
            LogoAppBarWithTwoActions(
                icon1 = R.drawable.search,
                icon2 = R.drawable.notification,
                title = stringResource(id = R.string.library),
                onSearchClick = {},
                onNotificationClick = {},
                onLogoClick = {},
                isNotificationIconVisible = false
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {

            TabRow(selectedTabIndex = tabIndex,
                modifier = Modifier.fillMaxWidth(),
                divider = {
                    Divider(color = MaterialTheme.colorScheme.outline)
                },
                containerColor = MaterialTheme.colorScheme.background,
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[tabIndex])
                            .height(4.dp)
                            .clip(RoundedCornerShape(8.dp)) // clip modifier not working
                            .padding(horizontal = 30.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onPrimary,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            ) {

                tabTitles.forEachIndexed { index, title ->
                    val selected = tabIndex == index
                    Tab(
                        selected = selected,
                        onClick = { tabIndex = index },
                        text = {
                            Text(
                                text = title,
                                color = if (selected) MaterialTheme.colorScheme.onPrimary
                                else MaterialTheme.colorScheme.onSecondary,
                                style = MaterialTheme.typography.titleSmall,
                            )
                        },
                        selectedContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                }

            }

            when (tabIndex) {
                0 -> MyQuizzoScreen(modifier = Modifier.fillMaxSize(),
                    onItemClick = {
                        navController.navigate(COLLECTION_DETAILS_MAIN)
                    })
                1 -> FavoritesScreen(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = DpDimensions.Normal),
                    onItemClick = {   navController.navigate(COLLECTION_DETAILS_MAIN) }
                )

                2 -> CollaborationScreen(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = DpDimensions.Normal),
                    onItemClick = {  navController.navigate(COLLECTION_DETAILS_MAIN)}
                )
            }

        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LibraryScreenPreview() {
    QuizzoTheme {
        LibraryScreen(rememberNavController())
    }
}
