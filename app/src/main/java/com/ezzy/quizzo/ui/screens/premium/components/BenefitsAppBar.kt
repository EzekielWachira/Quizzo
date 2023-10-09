package com.ezzy.quizzo.ui.screens.premium.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions

class BenefitsAppBar
@Composable
fun BenefitsAppBar(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit = {},
    onScanClicked: () -> Unit = {},
    onAddClicked: () -> Unit = {},
    @DrawableRes backIcon: Int,
    iconTint: Color = MaterialTheme.colorScheme.inversePrimary,
    iconsVisible: Boolean = false,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                all = DpDimensions.Smallest
            )
    ) {

        IconButton(onClick = { onBackClicked() }) {
            Icon(
                painter = painterResource(id = backIcon),
                contentDescription = "Back arrow",
                tint = iconTint
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        if (iconsVisible) {

            IconButton(onClick = { onScanClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.scan_2),
                    contentDescription = stringResource(R.string.scan_icon),
                    tint = iconTint
                )
            }

            IconButton(onClick = { onAddClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.add_2),
                    contentDescription = stringResource(R.string.add_icon),
                    tint = iconTint
                )
            }

        }
    }
}