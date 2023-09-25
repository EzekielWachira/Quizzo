package com.ezzy.quizzo.ui.screens.top_collections

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.ezzy.quizzo.ui.screens.home.collections
import com.ezzy.quizzo.ui.screens.home.components.CollectionItem
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TopCollectionsScreen(navController: NavController) {

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
                title = stringResource(id = R.string.top_collections),
                backIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackClick = { navController.popBackStack() },
                onSearchClick = { }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
        ) {

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
            ) {


                items(collections) { collection ->
                    CollectionItem(collection = collection,
                        onClick = {
                            navController.navigate("top_collection_details/${it.title}")
                        })
                }

            }
        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TopCollectionsScreenPreview() {
    QuizzoTheme {
        TopCollectionsScreen(rememberNavController())
    }
}