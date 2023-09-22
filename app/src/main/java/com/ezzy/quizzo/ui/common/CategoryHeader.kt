package com.ezzy.quizzo.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun CategoryHeader(
    modifier: Modifier = Modifier,
    categoryTitle: String,
    onClick: () -> Unit = {}
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Text(
            text = categoryTitle,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.weight(1f)
        )

        TextButton(onClick = onClick) {
            Text(
                text = stringResource(R.string.view_all),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = "Right arrow",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(DpDimensions.Dp24)
            )
        }

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CategoryHeaderPreview() {
    QuizzoTheme {
        CategoryHeader(categoryTitle = "Discover", modifier = Modifier.fillMaxWidth())
    }
}