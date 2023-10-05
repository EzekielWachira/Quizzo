package com.ezzy.quizzo.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun LogoAppBarWithThreeActions(
    modifier: Modifier = Modifier,
    onAction1Click: () -> Unit = {},
    onAction2Click: () -> Unit = {},
    onAction3Click: () -> Unit = {},
    @DrawableRes icon1: Int,
    @DrawableRes icon2: Int,
    @DrawableRes icon3: Int,
    title: String
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
            Image(
                painter = painterResource(id = R.drawable.quiz_24),
                contentDescription = "Quiz Logo",
                modifier = Modifier
                    .size(DpDimensions.Dp30)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = DpDimensions.Normal),
                textAlign = TextAlign.Start,
            )


            IconButton(onClick = onAction1Click) {
                Icon(
                    painter = painterResource(id = icon1),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }


            IconButton(onClick = onAction2Click) {
                Icon(
                    painter = painterResource(id = icon2),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            IconButton(onClick = onAction3Click) {
                Icon(
                    painter = painterResource(id = icon3),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LogoAppBarWithThreeActionsPreview() {
    QuizzoTheme {
        LogoAppBarWithThreeActions(
            icon1 = R.drawable.send,
            icon2 = R.drawable.stats_1,
            icon3 = R.drawable.settings,
            title = stringResource(id = R.string.profile)
        )
    }
}