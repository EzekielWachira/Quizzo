package com.ezzy.quizzo.ui.screens.notification_settings

import androidx.lifecycle.ViewModel
import com.ezzy.quizzo.ui.screens.notification_settings.models.NotificationSettingsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(): ViewModel() {
    private val _notificationsSettingsUIState: MutableStateFlow<NotificationSettingsUIState> = MutableStateFlow(
        NotificationSettingsUIState()
    )
    val notificationsSettingsUIState: StateFlow<NotificationSettingsUIState> get() =
        _notificationsSettingsUIState.asStateFlow()

    fun onUpdateSettings(index: Int, value: Boolean) {
        _notificationsSettingsUIState.update { currentState ->
            when(index) {
                0  -> currentState.copy(
                    pushNotificationsEnabled = value
                )
                1 -> currentState.copy(
                    newFollowersEnabled = value
                )
                2 -> currentState.copy(
                    newLikesEnabled = value
                )
                3 -> currentState.copy(
                    paymentAndSubscriptionEnabled = value
                )
                4 -> currentState.copy(
                    friendActivityEnabled = value
                )
                5 -> currentState.copy(
                    leaderboardEnabled = value
                )
                6 -> currentState.copy(
                    appUpdatesEnabled = value
                )
                7 -> currentState.copy(
                    newsAndPromotionEnabled = value
                )
                8 -> currentState.copy(
                    newsTipsAvailableEnabled = value
                )
                9 -> currentState.copy(
                    surveyInvitationEnabled = value
                )

                else -> currentState
            }
        }
    }
}

