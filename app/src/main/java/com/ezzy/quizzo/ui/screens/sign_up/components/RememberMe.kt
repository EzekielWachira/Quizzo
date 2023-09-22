package com.ezzy.quizzo.ui.screens.sign_up.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.ezzy.quizzo.ui.screens.sign_up.state.AccountState
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun RememberMe(
    modifier: Modifier = Modifier,
    state: AccountState,
    onCheckChange: (isChecked: Boolean) -> Unit = {}
) {
    Row(
        modifier = modifier.offset(x = (-14).dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = state.rememberMe, onCheckedChange = {
                onCheckChange(it)
            },
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        Text(
            text = stringResource(R.string.remember_me),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier
                .weight(1f)
                .padding(start = DpDimensions.Small)
        )

    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun RememberMePreview() {
    QuizzoTheme {
        RememberMe(state = AccountState())
    }
}