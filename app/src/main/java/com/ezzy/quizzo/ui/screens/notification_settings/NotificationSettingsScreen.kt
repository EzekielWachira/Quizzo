package com.ezzy.quizzo.ui.screens.notification_settings

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.CommonAppBarWithTitle
import com.ezzy.quizzo.ui.common.SwitchWithLeadingLabel
import com.ezzy.quizzo.ui.screens.notification_settings.models.NotificationSettingsUIState
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NotificationSettingsScreenRoute(
    onNavigateBack: () -> Unit,
    isSystemInDarkTheme: Boolean,
    viewModel: NotificationsViewModel = hiltViewModel()
) {
    val uiState by viewModel.notificationsSettingsUIState.collectAsStateWithLifecycle()
    NotificationSettingsScreen(
        state = uiState,
        isSystemInDarkTheme = isSystemInDarkTheme,
        onNavigateBack = onNavigateBack,
        onUpdateSettings = viewModel::onUpdateSettings
    )
}
@Composable
fun NotificationSettingsScreen(
    onNavigateBack: () -> Unit,
    onUpdateSettings: (index: Int, value: Boolean) -> Unit,
    state: NotificationSettingsUIState,
    isSystemInDarkTheme: Boolean
) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme

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
                title = stringResource(id = R.string.notifications),
                backIcon = Icons.AutoMirrored.Outlined.ArrowBack,
                onBackClick = onNavigateBack
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Small)
                .scrollable(rememberScrollState(), Orientation.Vertical),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.enable_push_notifications),
                isChecked = state.pushNotificationsEnabled,
                onValueChange = { onUpdateSettings(0, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.new_followers),
                isChecked = state.newFollowersEnabled,
                onValueChange = { onUpdateSettings(1, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.new_likes),
                isChecked = state.newLikesEnabled,
                onValueChange = { onUpdateSettings(2, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.payment_and_subscriptions),
                isChecked = state.paymentAndSubscriptionEnabled,
                onValueChange = { onUpdateSettings(3, it)},
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.friend_activity),
                isChecked = state.friendActivityEnabled,
                onValueChange = { onUpdateSettings(4, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.leaderboard),
                isChecked = state.leaderboardEnabled,
                onValueChange = { onUpdateSettings(5, it)},
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.app_updates),
                isChecked = state.appUpdatesEnabled,
                onValueChange = { onUpdateSettings(6, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.news_and_promotion),
                isChecked = state.newsAndPromotionEnabled,
                onValueChange = { onUpdateSettings(7, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.new_tips_available),
                isChecked = state.newsTipsAvailableEnabled,
                onValueChange = { onUpdateSettings(8, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
            SwitchWithLeadingLabel(
                label = stringResource(id = R.string.survey_invitation),
                isChecked = state.surveyInvitationEnabled,
                onValueChange = { onUpdateSettings(9, it) },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun NotificationSettingsScreen() {
    QuizzoTheme {
        NotificationSettingsScreen(
            state = NotificationSettingsUIState(),
            isSystemInDarkTheme = false,
            onNavigateBack = {},
            onUpdateSettings = { _, _ -> }
        )
    }
}