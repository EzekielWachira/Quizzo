package com.ezzy.quizzo.ui.screens.sign_up.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.ui.common.CommonAppBar
import com.ezzy.quizzo.ui.screens.sign_up.state.ProgressState

@Composable
fun AppBarWithProgress(modifier: Modifier = Modifier, progressState: ProgressState,
                       onBackClicked: () -> Unit = {}) {
    val progress by animateFloatAsState(
        targetValue = progressState.progress, label = "",
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing)
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CommonAppBar(onBackClicked = onBackClicked)
        LinearProgressIndicator(
            modifier = Modifier
                .weight(.2f)
                .height(10.dp)
                .clip(RoundedCornerShape(10.dp)),
            progress = progress,
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.secondaryContainer,
        )

        Spacer(modifier = Modifier.width(50.dp))
    }
}