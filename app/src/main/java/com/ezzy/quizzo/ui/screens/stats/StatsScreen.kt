package com.ezzy.quizzo.ui.screens.stats

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.AppBarWithOneAction
import com.ezzy.quizzo.ui.screens.stats.components.AchievementItem
import com.ezzy.quizzo.ui.screens.stats.components.GraphComponent
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.RoyalBlue65
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun StatsScreen(navController: NavController, isSystemInDarkTheme: Boolean) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons) Color.White else DarkGrey11, darkIcons = useDarkIcons
        )
    }


    Scaffold(topBar = {
        AppBarWithOneAction(rightIcon = R.drawable.more,
            backIcon = Icons.AutoMirrored.Outlined.ArrowBack,
            title = stringResource(R.string.my_statistics),
            onBackClick = { navController.popBackStack() },
            onClick = { })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
                .verticalScroll(scrollState)
        ) {

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            GraphComponent(modifier = Modifier.fillMaxWidth(), lineColor = RoyalBlue65)

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))
            Text(
                text = stringResource(R.string.your_achievements),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
            )
            Spacer(modifier = Modifier.height(DpDimensions.Small))


            achievements.chunked(2).forEach { items ->
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
                ) {
                    items.forEach { achievement ->
                        AchievementItem(achievement = achievement, modifier = Modifier.weight(1f))
                    }
                }
            }


        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StatsScreenPreview() {
    QuizzoTheme {
        StatsScreen(rememberNavController(), false)
    }
}