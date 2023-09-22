package com.ezzy.quizzo.ui.screens.home

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class Author(
    @DrawableRes val avatar: Int,
    val name: String
)

val authors = listOf(
    Author(avatar = R.drawable.person_1, name = "Rayford"),
    Author(avatar = R.drawable.person_2, name = "Willard"),
    Author(avatar = R.drawable.person_3, name = "Hannah"),
    Author(avatar = R.drawable.person_4, name = "Geoffrey"),
    Author(avatar = R.drawable.person_5, name = "Justin"),
)