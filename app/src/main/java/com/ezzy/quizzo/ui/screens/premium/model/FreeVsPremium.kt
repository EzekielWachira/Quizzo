package com.ezzy.quizzo.ui.screens.premium.model

data class FreeVsPremium(
    val title: String,
    val freeEligible: Boolean,
    val premiumEligible: Boolean = true
)

val differences = listOf(
    FreeVsPremium("Basic Features", true),
    FreeVsPremium("Learning Material", true),
    FreeVsPremium("Images Library", true),
    FreeVsPremium("Audio Library", true),
    FreeVsPremium("Remove Ads", false),
    FreeVsPremium("Up to 1000 Players", false),
    FreeVsPremium("Set Play Time", false),
    FreeVsPremium("No Waiting Time", false),
    FreeVsPremium("Boost Your Point", false),
    FreeVsPremium("Personalized Learning", false),
    FreeVsPremium("More Themes", false),
)
