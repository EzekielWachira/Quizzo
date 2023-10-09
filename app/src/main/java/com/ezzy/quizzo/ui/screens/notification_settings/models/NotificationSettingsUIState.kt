package com.ezzy.quizzo.ui.screens.notification_settings.models

data class NotificationSettingsUIState(
    val pushNotificationsEnabled: Boolean = true,
    val newFollowersEnabled: Boolean = true,
    val newLikesEnabled: Boolean = true,
    val paymentAndSubscriptionEnabled: Boolean = true,
    val friendActivityEnabled: Boolean = true,
    val leaderboardEnabled: Boolean = false,
    val appUpdatesEnabled: Boolean = true,
    val newsAndPromotionEnabled: Boolean = false,
    val newsTipsAvailableEnabled: Boolean = false,
    val surveyInvitationEnabled: Boolean = true,
)