package com.ezzy.quizzo.ui.screens.home

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class Collection(
    @DrawableRes val image: Int,
    val title: String
)
val collections = listOf(
    Collection(title = "Education", image = R.drawable.person_books),
    Collection(title = "Games", image = R.drawable.gaming_2),
    Collection(title = "Business", image = R.drawable.ideass),
)
