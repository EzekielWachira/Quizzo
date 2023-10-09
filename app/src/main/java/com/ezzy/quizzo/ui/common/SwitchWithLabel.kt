package com.ezzy.quizzo.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
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
    Row(
        modifier = modifier
            .toggleable(
                value = isChecked,
                role = Role.Switch,
                onValueChange = onValueChange
            )
            .padding(vertical = DpDimensions.Smallest),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .weight(1f)
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