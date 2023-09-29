package com.ezzy.quizzo.ui.screens.find_friends.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.CustomPadding
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun FriendsConnectTop(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
    onFacebookConnectClick: () -> Unit = {},
    onInviteFriends: () -> Unit = {},
) {
    val connects = listOf(
        Connect(
            title = "Search Contact",
            description = "Find friends by phone number",
            image = R.drawable.contacts_book
        ),
        Connect(
            title = "Connect to Facebook",
            description = "Find contacts via Facebook",
            image = R.drawable.facebook
        ),
        Connect(
            title = "Invite Friends",
            description = "Invite friends to play together",
            image = R.drawable.friends_2
        ),
    )

    Surface(
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        shape = RoundedCornerShape(DpDimensions.Normal),
        modifier = modifier,
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = DpDimensions.Small)
        ) {
            ConnectItem(
                connect = connects[0],
                onClick = onSearchClick,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(DpDimensions.Smallest))
            Divider(color = MaterialTheme.colorScheme.outline)
            Spacer(modifier = Modifier.height(DpDimensions.Smallest))
            ConnectItem(
                connect = connects[1],
                onClick = onFacebookConnectClick,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(DpDimensions.Smallest))
            Divider(color = MaterialTheme.colorScheme.outline)
            Spacer(modifier = Modifier.height(DpDimensions.Smallest))
            ConnectItem(
                connect = connects[2],
                onClick = onInviteFriends,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ConnectItem(
    onClick: () -> Unit = {}, modifier: Modifier = Modifier,
    connect: Connect
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(DpDimensions.Normal),
        onClick = { onClick() },
        modifier = modifier
    ) {
        CustomPadding(
            verticalPadding = DpDimensions.Small,
            horizontalPadding = DpDimensions.Small
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = connect.image), contentDescription = null,
                    modifier = Modifier.size(DpDimensions.Dp50)
                )

                Spacer(modifier = Modifier.width(DpDimensions.Small))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = connect.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.width(DpDimensions.Small))

                    Text(
                        text = connect.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.basicMarquee(),
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.width(DpDimensions.Small))

                IconButton(onClick = { onClick() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }
        }
    }
}

data class Connect(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FriendsConnectTopPreview() {
    QuizzoTheme {
        FriendsConnectTop(modifier = Modifier.fillMaxWidth())
    }
}