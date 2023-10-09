package com.ezzy.quizzo.ui.common

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun TwoButtons(
    button1Text: String,
    button2Text: String,
    onButton1Click: () -> Unit = {},
    onButton2Click: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Divider(color = MaterialTheme.colorScheme.outline)
        Spacer(modifier = Modifier.height(DpDimensions.Small))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = DpDimensions.Small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            Button(
                onClick = onButton1Click,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            ) {

                Text(
                    text = button1Text,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.tertiary
                )

            }

            Button(
                onClick = onButton2Click,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            ) {
                Text(
                    text = button2Text,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }


        }
        Spacer(modifier = Modifier.height(DpDimensions.Small))
    }

}