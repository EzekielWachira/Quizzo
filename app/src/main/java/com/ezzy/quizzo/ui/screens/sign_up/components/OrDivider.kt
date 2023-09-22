package com.ezzy.quizzo.ui.screens.sign_up.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun OrDivider(modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = stringResource(R.string.or),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(horizontal = DpDimensions.Small)
        )

        Divider(
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.weight(1f)
        )

    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OrDividerPreview() {
    QuizzoTheme {
        OrDivider(modifier = Modifier.fillMaxWidth())
    }
}