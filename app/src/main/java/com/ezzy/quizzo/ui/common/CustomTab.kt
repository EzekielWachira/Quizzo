package com.ezzy.quizzo.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun CustomTab(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    onClick: (index: Int) -> Unit = {},
    tabTitles: List<String>,
) {

    var currentIndex by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {
            repeat(tabTitles.size) {
                Tab(
                    isSelected = selectedIndex == it, text = tabTitles[it],
                    modifier = Modifier.weight(1f),
                    index = it,
                    onClick = { index -> onClick(index) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Tab(
    isSelected: Boolean,
    text: String,
    modifier: Modifier = Modifier,
    index: Int,
    onClick: (index: Int) -> Unit = {}
) {

    val color = animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimary
        else MaterialTheme.colorScheme.background,
        label = "",
        animationSpec = tween(500, easing = LinearEasing)
    )


    Surface(
        shape = RoundedCornerShape(DpDimensions.Dp30),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.onPrimary
        ),
        color = color.value,
        modifier = modifier,
        onClick = { onClick(index) }
    ) {

        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = DpDimensions.Normal,
                vertical = DpDimensions.Small
            ),
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )

    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CustomTabPreview() {
    QuizzoTheme {
        CustomTab(
            modifier = Modifier.fillMaxWidth(),
            tabTitles = listOf(
                stringResource(id = R.string.app_name),
                stringResource(id = R.string.collections),
                stringResource(R.string.about)
            )
        )
    }
}