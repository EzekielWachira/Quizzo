package com.ezzy.quizzo.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun HeaderWithSort(
    modifier: Modifier = Modifier,
    onSortClick: () -> Unit = {},
    title: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "Newest",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(horizontal = DpDimensions.Smallest)
        )

        IconButton(onClick = onSortClick) {
            Icon(
                painter = painterResource(id = R.drawable.sort),
                contentDescription = "Sort icon",
                modifier = Modifier.size(DpDimensions.Dp20),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }

    }
}