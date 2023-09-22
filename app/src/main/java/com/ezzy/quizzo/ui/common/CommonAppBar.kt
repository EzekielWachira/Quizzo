package com.ezzy.quizzo.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CommonAppBar(modifier: Modifier = Modifier, onBackClicked: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                all = 16.dp
            )
    ) {

        IconButton(onClick = { onBackClicked() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack, contentDescription = "Back arrow",
                tint = MaterialTheme.colorScheme.inversePrimary
            )
        }

    }
}