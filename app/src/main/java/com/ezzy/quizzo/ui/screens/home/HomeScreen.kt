package com.ezzy.quizzo.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.navigation.utils.NavDestinations.Discover.DISCOVER_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopAuthors.TOP_AUTHORS_MAIN
import com.ezzy.quizzo.navigation.utils.NavDestinations.TopCollections.TOP_COLLECTIONS_MAIN
import com.ezzy.quizzo.ui.common.CategoryHeader
import com.ezzy.quizzo.ui.common.CustomPadding
import com.ezzy.quizzo.ui.common.LogoAppBarWithTwoActions
import com.ezzy.quizzo.ui.screens.home.components.AuthorItem
import com.ezzy.quizzo.ui.screens.home.components.CollectionItem
import com.ezzy.quizzo.ui.screens.home.components.DiscoverItem
import com.ezzy.quizzo.ui.screens.home.components.TopCard
import com.ezzy.quizzo.ui.screens.home.components.TrendingItem
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(navController: NavController) {
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
            LogoAppBarWithTwoActions(
                icon1 = R.drawable.search,
                icon2 = R.drawable.notification,
                title = stringResource(id = R.string.app_name),
                onSearchClick = {},
                onNotificationClick = {},
                onLogoClick = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            CustomPadding(
                verticalPadding = DpDimensions.Normal,
                horizontalPadding = DpDimensions.Normal
            ) {
                TopCard(onButtonClick = {}, modifier = Modifier.fillMaxWidth())
            }

            CustomPadding(verticalPadding = 0.dp, horizontalPadding = DpDimensions.Normal) {
                CategoryHeader(
                    categoryTitle = stringResource(R.string.discover),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate(DISCOVER_MAIN) }
                )
            }

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(discovers) { discover ->
                    DiscoverItem(discover = discover)
                }
            }

            CustomPadding(
                verticalPadding = DpDimensions.Small,
                horizontalPadding = DpDimensions.Normal
            ) {
                CategoryHeader(
                    categoryTitle = stringResource(R.string.top_authors),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate(TOP_AUTHORS_MAIN) }
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(authors, key = { it.name }) { author ->
                    AuthorItem(author = author)
                }
            }

            CustomPadding(
                verticalPadding = DpDimensions.Small,
                horizontalPadding = DpDimensions.Normal
            ) {
                CategoryHeader(
                    categoryTitle = stringResource(R.string.top_collections),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate(TOP_COLLECTIONS_MAIN) }
                )
            }


            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(collections) { collection ->
                    CollectionItem(collection = collection)
                }
            }

            CustomPadding(
                verticalPadding = DpDimensions.Small,
                horizontalPadding = DpDimensions.Normal
            ) {
                CategoryHeader(
                    categoryTitle = stringResource(R.string.trending_quiz),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(trending) { trending ->
                    TrendingItem(discover = trending)
                }
            }

            CustomPadding(
                verticalPadding = DpDimensions.Small,
                horizontalPadding = DpDimensions.Normal
            ) {
                CategoryHeader(
                    categoryTitle = stringResource(R.string.top_pics),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(topPics) { topPic ->
                    TrendingItem(discover = topPic)
                }
            }

            Spacer(modifier = Modifier.height(DpDimensions.Dp30))

        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    QuizzoTheme {
        HomeScreen(rememberNavController())
    }
}