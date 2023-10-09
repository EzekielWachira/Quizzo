package com.ezzy.quizzo.ui.screens.premium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ezzy.quizzo.ui.screens.premium.components.BenefitItem
import com.ezzy.quizzo.ui.screens.premium.model.premiumBenefits
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun PremiumBenefits(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(DpDimensions.Normal),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = DpDimensions.Normal, vertical = DpDimensions.Small)
        ) {

            itemsIndexed(premiumBenefits) { index, item ->
                BenefitItem(benefit = item, index = index )
            }

        }
    }

}



