package com.ezzy.quizzo.ui.screens.top_authors

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.AppBarWithSearch
import com.ezzy.quizzo.ui.common.CustomStickyHeader
import com.ezzy.quizzo.ui.screens.home.authors2
import com.ezzy.quizzo.ui.screens.top_authors.components.AuthorItem
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.utils.showToast
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopAuthorsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val context = LocalContext.current

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
                title = stringResource(R.string.top_authors),
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
                .padding(horizontal = DpDimensions.Small)
        ) {

            authors2.sortedBy { it.name[0] }.groupBy { it.name[0] }.forEach { (char, authors) ->
                stickyHeader {
                    CustomStickyHeader(text = char.toString(), modifier = Modifier.fillMaxWidth())
                }

                items(authors) { author ->
                    AuthorItem(author = author, modifier = Modifier.fillMaxWidth(),
                        onFollowClick = { context.showToast("Follow") },
                        onUnFollowClick = { context.showToast("Un Follow") },
                        onClick = { author ->
                            navController.navigate("top_authors_details/${Gson().toJson(author)}")
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
fun TopAuthorsScreenPreview() {
    QuizzoTheme {
        TopAuthorsScreen(rememberNavController())
    }
}

