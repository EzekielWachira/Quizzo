package com.ezzy.quizzo.ui.screens.premium.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import com.ezzy.quizzo.ui.screens.premium.model.PremiumBenefit
import com.ezzy.quizzo.ui.screens.premium.model.premiumBenefits
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun BenefitItem(
    modifier: Modifier = Modifier,
    benefit: PremiumBenefit,
    index: Int,
    size: Int = premiumBenefits.size
) {

    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            modifier = Modifier
                .padding(vertical = DpDimensions.Normal)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = benefit.image),
                contentDescription = null,
                modifier = Modifier.size(DpDimensions.Dp40)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Smallest)
            ) {

                Text(
                    text = benefit.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary
                )

                Text(
                    text = benefit.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary
                )

            }
        }

        if (index < size - 1) {
            Divider(color = MaterialTheme.colorScheme.outline)
        }
    }

}