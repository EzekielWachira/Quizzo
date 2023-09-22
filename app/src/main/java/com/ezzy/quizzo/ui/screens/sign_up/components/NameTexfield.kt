package com.ezzy.quizzo.ui.screens.sign_up.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.sign_up.state.ProfileState
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.utils.bottomBorder

@Composable
fun NameTexfield(
    modifier: Modifier = Modifier,
    state: ProfileState,
    onTextChange: (String) -> Unit = {}
) {

    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {

        Column {
            Text(
                text = stringResource(R.string.full_name),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .bottomBorder(1.dp, MaterialTheme.colorScheme.onPrimary)
            ) {
                TextField(
                    value = state.name, onValueChange = { value ->
                        onTextChange(value)
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.full_name),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp)
                        .offset(x=(-16).dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    textStyle = MaterialTheme.typography.titleMedium
                )
            }


        }
    }

}


@Preview
@Composable
fun NameTexfieldPreview() {
    QuizzoTheme {
        NameTexfield(state = ProfileState())
    }
}