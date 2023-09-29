package com.ezzy.quizzo.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.state.SearchState
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun SearchBar(
    placeholder: String,
    modifier: Modifier = Modifier,
    state: SearchState,
    onSearch: (String) -> Unit = {}
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Normal),
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
    ) {
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding( horizontal = DpDimensions.Normal)
        ) {
            
            Icon(painter = painterResource(id = R.drawable.search), contentDescription = "search icon",
                tint = MaterialTheme.colorScheme.inverseSurface,
                modifier = Modifier.size(DpDimensions.Dp20))


            TextField(
                value = state.query, onValueChange = { value ->
                    onSearch(value)
                },
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.inverseSurface
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.inversePrimary
                ),
                modifier = Modifier.weight(1f).height(DpDimensions.Dp50),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchBarPreview() {
    QuizzoTheme {
        SearchBar(
            placeholder = stringResource(R.string.search_email_name_),
            state = SearchState(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}