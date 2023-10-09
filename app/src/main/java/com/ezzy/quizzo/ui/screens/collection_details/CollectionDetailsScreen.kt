package com.ezzy.quizzo.ui.screens.collection_details

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.common.CategoryHeader
import com.ezzy.quizzo.ui.common.QuizItem
import com.ezzy.quizzo.ui.screens.collection_details.components.AccountComponent
import com.ezzy.quizzo.ui.screens.collection_details.components.CollectionDetailsTopBar
import com.ezzy.quizzo.ui.screens.collection_details.components.menuItems
import com.ezzy.quizzo.ui.screens.home.authors2
import com.ezzy.quizzo.ui.screens.top_collection_details.components.TopCard
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.utils.showToast
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CollectionDetailsScreen(navController: NavController, isSystemInDarkTheme: Boolean) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme
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
            CollectionDetailsTopBar(menuItems = menuItems, modifier = Modifier.fillMaxWidth(),
                onCloseClick = { navController.popBackStack() },
                onShareClick = { context.showToast("Share") },
                onGeneratePinClick = { context.showToast("Generate PIN") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                    TopCard(
                        Modifier.fillMaxWidth(),
                        height = 180.dp
                    )
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                    Text(
                        text = "Back to School Quiz Game",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                    Spacer(modifier = Modifier.height(DpDimensions.Dp20))
                    Stats(Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                    AccountComponent(author = authors2[0], modifier = Modifier.fillMaxWidth(),
                        onEditClick = {})
                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                    Text(
                        text = stringResource(R.string.description),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                    Text(
                        text = stringResource(R.string.dummy_text),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondary,
                        maxLines = 6,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Small))

                    CategoryHeader(
                        categoryTitle = "Questions (10)",
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                }
            }

            items(quizzes.takeLast(3)) { quiz ->
                QuizItem(quiz = quiz, modifier = Modifier.fillMaxWidth(),
                    onClick = {})
            }

        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CollectionDetailsScreenPreview() {
    QuizzoTheme {
        CollectionDetailsScreen(rememberNavController(), true)
    }
}


@Composable
fun Stats(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Divider(color = MaterialTheme.colorScheme.outline)
        Spacer(modifier = Modifier.height(DpDimensions.Small))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = DpDimensions.Small)
            ) {
                Text(
                    text = "10",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = stringResource(R.string.questions),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Divider(
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier
                    .height(60.dp)
                    .width(1.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = DpDimensions.Small)
            ) {
                Text(
                    text = "20",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = stringResource(R.string.played),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Divider(
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier
                    .height(60.dp)
                    .width(1.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = DpDimensions.Small)
            ) {
                Text(
                    text = "23",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = stringResource(R.string.favorited),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Divider(
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier
                    .height(60.dp)
                    .width(1.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = DpDimensions.Small)
            ) {
                Text(
                    text = "33",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = stringResource(R.string.shared),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }


        }

        Spacer(modifier = Modifier.height(DpDimensions.Small))
        Divider(color = MaterialTheme.colorScheme.outline)
    }
}