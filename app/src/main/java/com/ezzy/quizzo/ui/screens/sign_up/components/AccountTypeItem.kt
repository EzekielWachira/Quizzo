package com.ezzy.quizzo.ui.screens.sign_up.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.ui.screens.sign_up.AccountType
import com.ezzy.quizzo.ui.screens.sign_up.accountTypes
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.Trans12

@Composable
fun AccountTypeItem(
    modifier: Modifier = Modifier, accountType: AccountType,
    onClick: () -> Unit = {}
) {

    Surface(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier

                    .background(
                        accountType.color,
                        shape = RoundedCornerShape(
                            topStart = DpDimensions.Small,
                            bottomStart = DpDimensions.Small
                        )
                    )
                    .clip(
                        RoundedCornerShape(
                            topStart = DpDimensions.Small,
                            bottomStart = DpDimensions.Small
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = modifier
                        .padding(DpDimensions.Normal)
                        .background(Trans12, CircleShape)
                        .clip(CircleShape)
                        .size(50.dp),
                    contentAlignment = Alignment.Center,
                ) {

                    Icon(
                        painter = painterResource(id = accountType.icon),
                        contentDescription = accountType.title + " icon",
                        modifier = Modifier.size(DpDimensions.Dp20),
                        tint = Color.White
                    )

                }

            }

            Text(
                text = accountType.title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = DpDimensions.Normal)
            )

        }

    }

}


@Preview
@Composable
fun AccountTypeItemPreview() {
    QuizzoTheme {
        AccountTypeItem(accountType = accountTypes[0])
    }
}