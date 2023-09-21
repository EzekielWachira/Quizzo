package com.ezzy.quizzo.ui.screens.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import java.util.Locale

@Composable
fun ButtonsSection(
    modifier: Modifier = Modifier,
    onGetStartedClick: () -> Unit = {},
    onHaveAccountClick: () -> Unit = {}
) {

    Box(modifier = modifier, contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Divider(color = MaterialTheme.colorScheme.outline)

            Spacer(modifier = Modifier.height(DpDimensions.Dp30))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DpDimensions.Normal)
            ) {

                Button(
                    onClick = onGetStartedClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.fillMaxWidth()
                        .height(50.dp)
                ) {

                    Text(
                        text = stringResource(R.string.get_started).uppercase(Locale.getDefault()),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )

                }

                Spacer(modifier = Modifier.height(DpDimensions.Normal))

                Button(
                    onClick = onGetStartedClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    modifier = Modifier.fillMaxWidth()
                        .height(50.dp)
                ) {

                    Text(
                        text = stringResource(R.string.already_have_account).uppercase(Locale.getDefault()),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )

                }

            }

            Spacer(modifier = Modifier.height(DpDimensions.Dp30))

        }

    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ButtonsSectionPreview() {
    QuizzoTheme {
        ButtonsSection()
    }
}