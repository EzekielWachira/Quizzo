package com.ezzy.quizzo.ui.screens.sign_up

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.Blue59
import com.ezzy.quizzo.ui.theme.Coral70
import com.ezzy.quizzo.ui.theme.Orange53
import com.ezzy.quizzo.ui.theme.Turquoise48

data class AccountType(
    val color: Color,
    @DrawableRes val icon: Int,
    val title: String
)

val accountTypes = listOf(
    AccountType(color = Blue59, icon = R.drawable.account_single, title = "Personal"),
    AccountType(color = Orange53, icon = R.drawable.group_2, title = "Teacher"),
    AccountType(color = Turquoise48, icon = R.drawable.group_three, title = "Student"),
    AccountType(color = Coral70, icon = R.drawable.business, title = "Professional"),
)
val workplaces = listOf(
    AccountType(color = Blue59, icon = R.drawable.book, title = "School"),
    AccountType(color = Orange53, icon = R.drawable.higher_education, title = "Higher Education"),
    AccountType(color = Turquoise48, icon = R.drawable.group_three, title = "Teams"),
    AccountType(color = Coral70, icon = R.drawable.business, title = "Business"),
)

