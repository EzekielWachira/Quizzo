package com.ezzy.quizzo.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun SwitchWithLeadingLabel(
    label: String,
    isChecked: Boolean,
    onValueChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = isChecked,
                    role = Role.Switch,
                    onValueChange = onValueChange
                )
                .padding(
                    vertical = DpDimensions.Small,
                    horizontal = DpDimensions.Normal
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .weight(1f),
                color = MaterialTheme.colorScheme.inversePrimary
            )
            Switch(
                checked = isChecked,
                onCheckedChange = null,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchWithLeadingLabelPreview() {
    QuizzoTheme {
        SwitchWithLeadingLabel(
            label = "Personal",
            isChecked = true,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}