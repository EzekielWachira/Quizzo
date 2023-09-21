package com.ezzy.quizzo.ui.screens.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ezzy.quizzo.R

data class OnBoarding(
    @DrawableRes val image: Int,
    @StringRes val title: Int
)


val onBoardingItems = listOf(
    OnBoarding(image = R.drawable.gaming, title = R.string.create_share),
    OnBoarding(image = R.drawable.outer_space, title = R.string.find_fun),
    OnBoarding(image = R.drawable.friends, title = R.string.play_and_take),
)
