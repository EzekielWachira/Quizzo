package com.ezzy.quizzo.ui.common

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun CommonAppBarWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes backIcon: Int,
    onBackClick: () -> Unit = {}
) {
    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Normal,
                vertical = DpDimensions.Small
            )
        ) {

            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = backIcon),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = DpDimensions.Normal),
                textAlign = TextAlign.Start,
            )
        }
    }
}


@Composable
fun CommonAppBarWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    backIcon: ImageVector,
    onBackClick: () -> Unit = {}
) {
    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Smallest,
                vertical = DpDimensions.Small
            )
        ) {

            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = backIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = DpDimensions.Normal),
                textAlign = TextAlign.Start,
            )
        }
    }
}