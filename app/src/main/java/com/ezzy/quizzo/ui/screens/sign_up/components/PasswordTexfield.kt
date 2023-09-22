package com.ezzy.quizzo.ui.screens.sign_up.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.sign_up.state.AccountState
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.utils.bottomBorder

@Composable
fun PasswordTexfield(
    modifier: Modifier = Modifier,
    state: AccountState,
    onTextChange: (String) -> Unit = {},
    onCalendarIconClick: () -> Unit = {}
) {

    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {

        Column {
            Text(
                text = stringResource(R.string.password),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .bottomBorder(1.dp, MaterialTheme.colorScheme.onPrimary),
                verticalAlignment = Alignment.CenterVertically
            ) {


                TextField(
                    value = state.password, onValueChange = { value ->
                        onTextChange(value)
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.enter_password),
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
                        cursorColor = MaterialTheme.colorScheme.onPrimary,
                        focusedTextColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 0.dp)
                        .offset(x = (-16).dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = MaterialTheme.typography.titleMedium,
                    trailingIcon = {
                        val toggleIcon = if (isPasswordVisible)
                            painterResource(id = R.drawable.visibility)
                        else painterResource(id = R.drawable.visibility_off)

                        IconButton(
                            onClick = { isPasswordVisible = !isPasswordVisible },
                        ) {
                            Icon(
                                painter = toggleIcon, contentDescription = "",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                )

            }


        }
    }

}


@Preview
@Composable
fun PasswordTexfieldPreview() {
    QuizzoTheme {
        PasswordTexfield(state = AccountState())
    }
}