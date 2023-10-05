package com.ezzy.quizzo.ui.screens.settings.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.Orange53
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun SettingsItem(
    title: String,
    @DrawableRes icon: Int,
    iconTint: Color,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    isRightIconVisible: Boolean = true
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Normal),
        onClick = { onClick() },
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            Box(
                modifier = Modifier
                    .padding(DpDimensions.Normal)
                    .background(iconTint.copy(alpha = .1f), CircleShape)
                    .clip(CircleShape)
                    .size(50.dp),
                contentAlignment = Alignment.Center,
            ) {

                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(DpDimensions.Dp20),
                    tint = iconTint
                )

            }

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.weight(1f)
            )


            if (isRightIconVisible)
                IconButton(onClick = { onClick() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.inversePrimary,
                        modifier = Modifier.size(DpDimensions.Dp20)
                    )
                }


        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SettingsItemPreview() {
    QuizzoTheme {
        SettingsItem(
            "Personal Info", R.drawable.account_single, Orange53,
            modifier = Modifier.fillMaxWidth()
        )
    }
}