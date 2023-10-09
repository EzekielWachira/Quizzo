package com.ezzy.quizzo.ui.screens.premium.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ezzy.quizzo.ui.screens.premium.model.FreeVsPremium
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun FreeVsPremiumItem(
    modifier: Modifier = Modifier,
    freeVsPremium: FreeVsPremium
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
    ) {
        Text(
            text = freeVsPremium.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.weight(1f)
        )

        Checkbox(
            checked = freeVsPremium.freeEligible,
            onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = MaterialTheme.colorScheme.onPrimary,
            ),
//            enabled = false
        )

        Checkbox(
            checked = freeVsPremium.premiumEligible,
            onCheckedChange = {},
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = MaterialTheme.colorScheme.onPrimary,
            ),
//            enabled = false
        )
    }

}