package com.ezzy.quizzo.ui.screens.followers

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.ui.common.AppBarWithSearch
import com.ezzy.quizzo.ui.common.CustomTab
import com.ezzy.quizzo.ui.screens.home.authors2
import com.ezzy.quizzo.ui.screens.top_authors.components.AuthorItem
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.utils.showToast
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson

@Composable
fun FollowersScreen(navController: NavController, isSystemInDarkTheme: Boolean) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme
    val context = LocalContext.current

    val tabTitles = listOf(
        "Followers", "Following"
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
            AppBarWithSearch(
                title = "Andrew Ainsley",
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
            CustomTab(
                selectedIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
                onClick = { index -> selectedTabIndex = index },
                tabTitles = tabTitles
            )

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Smallest),
                modifier = Modifier.weight(1f)
            ) {
                items(when (selectedTabIndex) {
                    0 -> authors2
                    1 -> authors2.filter { author -> !author.isFollowing }
                    else -> emptyList()
                }) { author ->
                    AuthorItem(author = author, modifier = Modifier.fillMaxWidth(),
                        onFollowClick = { context.showToast("Follow") },
                        onUnFollowClick = { context.showToast("Un Follow") },
                        onClick = { author ->
//                            navController.navigate("top_authors_details/${Gson().toJson(author)}")
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FollowersScreenPreview() {
    QuizzoTheme {
        FollowersScreen(rememberNavController(), false)
    }
}