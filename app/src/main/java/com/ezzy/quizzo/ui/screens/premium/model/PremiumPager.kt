package com.ezzy.quizzo.ui.screens.premium.model

import androidx.compose.runtime.Composable
import com.ezzy.quizzo.ui.screens.premium.FreeVsPremium
import com.ezzy.quizzo.ui.screens.premium.PremiumBenefits

data class PremiumPager(
    val title: String,
    val buttonText: String
)

val pagerItems = listOf(
   PremiumPager( "Premium Benefits", "Go Premium Now"),
   PremiumPager( "Free Vs Premium", "Go Premium Now"),
   PremiumPager( "Choose Plan", "Continue"),
   PremiumPager( "Select Payment", "Confirm Payment"),
   PremiumPager( "", "Ok, Great"),
)