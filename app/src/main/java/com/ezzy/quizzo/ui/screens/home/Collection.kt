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
    Collection(title = "Sports", image = R.drawable.sports),
    Collection(title = "Food & Drinks", image = R.drawable.food),
    Collection(title = "Health", image = R.drawable.health),
    Collection(title = "Kids", image = R.drawable.kid),
    Collection(title = "Plants", image = R.drawable.plant),
)
