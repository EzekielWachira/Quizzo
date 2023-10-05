package com.ezzy.quizzo.ui.screens.settings

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.CommonAppBarWithTitle
import com.ezzy.quizzo.ui.screens.home.components.TopCard
import com.ezzy.quizzo.ui.screens.settings.components.SettingsItem
import com.ezzy.quizzo.ui.theme.Blue59
import com.ezzy.quizzo.ui.theme.Coral70
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.Orange53
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.RoyalBlue65
import com.ezzy.quizzo.ui.theme.Turquoise48
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SettingsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val coroutineScope = rememberCoroutineScope()
    val viewModel: SettingsViewModel = hiltViewModel()

    val switchState by viewModel.switchState.collectAsStateWithLifecycle()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            CommonAppBarWithTitle(
                title = stringResource(R.string.settings),
                backIcon = Icons.AutoMirrored.Outlined.ArrowBack
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            TopCard(
                title = stringResource(R.string.play_quizzes_without_ads),
                buttonText = "GO PREMIUM",
                image = R.drawable.sky
            )
            Spacer(modifier = Modifier.height(DpDimensions.Dp20))


            SettingsItem(
                title = stringResource(R.string.personal_info),
                icon = R.drawable.account_single,
                iconTint = Orange53,
                modifier = Modifier.fillMaxWidth()
            )



            SettingsItem(
                title = stringResource(R.string.notifications),
                icon = R.drawable.notification_filled,
                iconTint = Coral70,
                modifier = Modifier.fillMaxWidth()
            )


            SettingsItem(
                title = stringResource(R.string.music_effects),
                icon = R.drawable.volume,
                iconTint = RoyalBlue65,
                modifier = Modifier.fillMaxWidth()
            )


            SettingsItem(
                title = stringResource(R.string.security),
                icon = R.drawable.security,
                iconTint = Turquoise48,
                modifier = Modifier.fillMaxWidth()
            )



            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                SettingsItem(
                    title = stringResource(R.string.dark_mode),
                    icon = R.drawable.dark_theme,
                    iconTint = Blue59,
                    modifier = Modifier.weight(1f),
                    isRightIconVisible = false
                )

                Switch(checked = switchState.isChecked, onCheckedChange = viewModel::onCheckChange)
            }



            SettingsItem(
                title = stringResource(R.string.help_center),
                icon = R.drawable.help,
                iconTint = Orange53,
                modifier = Modifier.fillMaxWidth()
            )


            SettingsItem(
                title = stringResource(R.string.about_quizzo),
                icon = R.drawable.about,
                iconTint = RoyalBlue65,
                modifier = Modifier.fillMaxWidth()
            )


            SettingsItem(
                title = stringResource(R.string.logout),
                icon = R.drawable.logout,
                iconTint = Coral70,
                modifier = Modifier.fillMaxWidth(),
                isRightIconVisible = false
            )

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))
        }

    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SettingsScreenPreview() {
    QuizzoTheme {
        SettingsScreen(rememberNavController())
    }
}