package com.ezzy.quizzo.ui.screens.top_authors_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.common.CustomTab
import com.ezzy.quizzo.ui.common.QuizItem
import com.ezzy.quizzo.ui.screens.home.Author
import com.ezzy.quizzo.ui.screens.home.authors2
import com.ezzy.quizzo.ui.screens.home.collections
import com.ezzy.quizzo.ui.screens.home.components.CollectionItem
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel
import com.ezzy.quizzo.ui.screens.top_authors.components.AuthorItem
import com.ezzy.quizzo.ui.screens.top_authors_details.components.TopAuthorStats
import com.ezzy.quizzo.ui.screens.top_collection_details.components.AppBarWithSendAndMore
import com.ezzy.quizzo.ui.screens.top_collection_details.components.TopCard
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.gson.Gson

@Composable
fun TopAuthorsDetailsScreen(navController: NavController, authorStr: String?) {

    val systemUiController = rememberSystemUiController()
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isDarkModeEnabled by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)
    val useDarkIcons = !isDarkModeEnabled
    var author by rememberSaveable {
        mutableStateOf<Author?>(null)
    }
    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(id = R.string.app_name),
        stringResource(id = R.string.collections),
        stringResource(R.string.about)
    )

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }

    LaunchedEffect(key1 = true) {
        author = Gson().fromJson(authorStr, Author::class.java)
    }

    Scaffold(
        topBar = {
            AppBarWithSendAndMore(
                modifier = Modifier.fillMaxWidth(),
                onBackClick = { navController.popBackStack() },
                onMoreClick = { },
                onSendClick = { }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Normal)
        ) {

            item {
                Column {
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                    TopCard(Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                    author?.let { AuthorItem(author = it, modifier = Modifier.fillMaxWidth()) }
                    TopAuthorStats(Modifier.fillMaxWidth())
                    CustomTab(
                        selectedIndex = selectedTabIndex,
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { index -> selectedTabIndex = index },
                        tabTitles = tabTitles
                    )
                    when (selectedTabIndex) {
                        0, 1 -> {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text(
                                    text = "49 Collections",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = MaterialTheme.colorScheme.inversePrimary,
                                    modifier = Modifier.weight(1f)
                                )

                                Text(
                                    text = "Newest",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.padding(horizontal = DpDimensions.Smallest)
                                )

                                IconButton(onClick = { }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.sort),
                                        contentDescription = "Sort icon",
                                        modifier = Modifier.size(DpDimensions.Dp20),
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }

                            }
                        }
                    }
                }
            }

            when (selectedTabIndex) {
                0 -> {
                    items(quizzes) { quiz ->
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
private fun TopAuthorsDetailsScreenPreview() {
    QuizzoTheme {
        TopAuthorsDetailsScreen(rememberNavController(), Gson().toJson(authors2[0]))
    }
}