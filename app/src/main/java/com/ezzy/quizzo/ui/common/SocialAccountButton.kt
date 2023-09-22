package com.ezzy.quizzo.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SocialAccountButton(
    label: String,
    @DrawableRes image: Int,
    onButtonClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background,
        onClick = onButtonClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = DpDimensions.Dp20,
                    vertical = DpDimensions.Small
                )
        ) {

            Image(
                painter = painterResource(id = image), contentDescription = "$label icon",
                modifier = Modifier.size(DpDimensions.Dp24)
            )

            Text(
                text = label, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.padding(start = DpDimensions.Small)
            )

        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SocialAccountButton2(
    label: String,
    @DrawableRes image: Int,
    onButtonClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background,
        onClick = onButtonClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = DpDimensions.Dp20,
                    vertical = DpDimensions.Small
                )
        ) {

            Icon(
                painter = painterResource(id = image), contentDescription = "$label icon",
                modifier = Modifier.size(DpDimensions.Dp24),
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )

            Text(
                text = label, style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.padding(start = DpDimensions.Small)
            )

        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SocialAccountButtonPreview() {
    QuizzoTheme {
        SocialAccountButton(label = stringResource(R.string.continue_with_google),
            image = R.drawable.google,
            modifier = Modifier.fillMaxWidth())
    }
}