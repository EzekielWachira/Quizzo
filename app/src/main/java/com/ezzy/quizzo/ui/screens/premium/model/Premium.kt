package com.ezzy.quizzo.ui.screens.premium.model

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class PremiumBenefit(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)


val premiumBenefits = listOf(
    PremiumBenefit(
        title = "Remove Ads",
        description = "Ad-free and hassle-free with a premium subscription",
        image = R.drawable.ad
    ),
    PremiumBenefit(
        title = "Up to 1000 Players",
        description = "You can play with participants reaching 1000 in each game.",
        image = R.drawable.star2
    ),
    PremiumBenefit(
        title = "Set Pay Time",
        description = "You can set the time when the game will start and end.",
        image = R.drawable.date_calendar
    ),
    PremiumBenefit(
        title = "No Waiting Time",
        description = "With premium, you can skip the waiting time.",
        image = R.drawable.hourglass
    ),
    PremiumBenefit(
        title = "Boost Your Point",
        description = "Get more point with premium subscription.",
        image = R.drawable.lightning
    ),
    PremiumBenefit(
        title = "Personalized Learning",
        description = "Assign structured and personalized Learning.",
        image = R.drawable.notebook
    ),
    PremiumBenefit(
        title = "More Theme",
        description = "Add more and various themes for your game.",
        image = R.drawable.themes
    ),
)