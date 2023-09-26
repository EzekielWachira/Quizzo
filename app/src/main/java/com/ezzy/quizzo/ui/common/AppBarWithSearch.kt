package com.ezzy.quizzo.ui.common

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
fun AppBarWithSearch(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    title: String,
    @DrawableRes backIcon: Int
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

            IconButton(onClick = onSearchClick) {
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

            IconButton(onClick = onSearchClick) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    }
}

@Composable
fun AppBarWithSearch(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    title: String,
    backIcon: ImageVector
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

            IconButton(onClick = onSearchClick) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    }
}