package com.ezzy.quizzo.ui.screens.home

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class Collection(
    @DrawableRes val image: Int,
    val title: String
)
val collections = listOf(
    Collection(title = "Education", image = R.drawable.colors),
    Collection(title = "Games", image = R.drawable.vehicle_1),
    Collection(title = "Business", image = R.drawable.business_2),
)
