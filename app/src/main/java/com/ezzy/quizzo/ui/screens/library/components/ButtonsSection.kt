package com.ezzy.quizzo.ui.screens.library.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun ButtonsSection(
    modifier: Modifier = Modifier,
    onLeftButtonClick: () -> Unit = {},
    onRightButtonClick: () -> Unit = {},
    leftButtonText: String,
    rightButtonText: String,
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Button(
                onClick = {
                    onRightButtonClick()
                },
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = rightButtonText,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White,
                )
            }

            OutlinedButton(
                onClick = { onLeftButtonClick() },
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
            ) {
                Text(
                    text = leftButtonText,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}


@Preview
@Composable
fun ButtonsSectionPreview() {
    QuizzoTheme {
        ButtonsSection(
            modifier = Modifier.fillMaxWidth(),
            leftButtonText = "Quizzo",
            rightButtonText = "Collections"
        )
    }
}