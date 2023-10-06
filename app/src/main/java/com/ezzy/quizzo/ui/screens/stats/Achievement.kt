package com.ezzy.quizzo.ui.screens.stats

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class Achievement(
    val value: String,
    val name: String,
    @DrawableRes val icon: Int
)


val achievements = listOf(
    Achievement(value = "85", name = "Quizzo", icon = R.drawable.quiz_logo),
    Achievement(value = "223,234", name = "Lifetime Point", icon = R.drawable.points),
    Achievement(value = "123", name = "Quiz Passed", icon = R.drawable.flame),
    Achievement(value = "23", name = "Top 3 Positions", icon = R.drawable.achievement),
    Achievement(value = "432", name = "Challenge Passed", icon = R.drawable.dart),
    Achievement(value = "56", name = "Fastest Record", icon = R.drawable.clock),
)
