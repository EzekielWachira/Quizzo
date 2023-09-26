package com.ezzy.quizzo.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun CustomStickyHeader(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = DpDimensions.Smallest, horizontal = DpDimensions.Small)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {
            Text(
                text = text, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )


            Divider(color = MaterialTheme.colorScheme.outline)
        }
    }
}