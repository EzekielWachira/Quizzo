package com.ezzy.quizzo.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun CustomPadding(
    verticalPadding: Dp,
    horizontalPadding: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier.padding(
            horizontal = horizontalPadding,
            vertical = verticalPadding
        )
    ) {
        content()
    }
}