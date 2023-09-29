package com.ezzy.quizzo.ui.screens.find_friends.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.CustomPadding
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun FriendItem(
    friend: Friend,
    onClick: (Friend) -> Unit = {},
    onFollowClick: (Friend) -> Unit = {},
    onUnFollowClick: (Friend) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(DpDimensions.Small),
        onClick = { onClick(friend) }
    ) {
        CustomPadding(
            verticalPadding = DpDimensions.Small,
            horizontalPadding = DpDimensions.Small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = friend.image), contentDescription = null,
                    modifier = Modifier
                        .size(DpDimensions.Dp30)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(DpDimensions.Small))

                Text(
                    text = friend.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.weight(1f)
                )

                if (friend.isFollowing) {
                    OutlinedButton(
                        onClick = { onUnFollowClick(friend) },
                        modifier = Modifier.height(35.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
                    ) {
                        Text(
                            text = stringResource(R.string.following),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                } else {
                    Button(
                        onClick = {
                            onFollowClick(friend)
                        }, modifier = Modifier.height(35.dp), colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.follow),
                            style = MaterialTheme.typography.titleSmall,
                            color = Color.White,
                        )
                    }
                }


            }
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FriendItemPreview() {
    QuizzoTheme {
        FriendItem(friendList[0], modifier = Modifier.fillMaxWidth())
    }
}


data class Friend(
    val name: String,
    @DrawableRes val image: Int = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,
        R.drawable.person_5,
    ).random(),
    val isFollowing: Boolean = false
)

val friendList = listOf(
    Friend(name = "Rowan Atkinson", isFollowing = false),
    Friend(name = "Jennifer Aniston", isFollowing = false),
    Friend(name = "George Clooney", isFollowing = false),
    Friend(name = "Emma Watson", isFollowing = false),
    Friend(name = "Tom Hanks", isFollowing = false),
    Friend(name = "Mila Kunis", isFollowing = false),
    Friend(name = "Brad Pitt", isFollowing = false),
    Friend(name = "Scarlett Johansson", isFollowing = false),
    Friend(name = "Leonardo DiCaprio", isFollowing = false),
    Friend(name = "Angelina Jolie", isFollowing = false),
    Friend(name = "Johnny Depp", isFollowing = false),
    Friend(name = "Natalie Portman", isFollowing = false),
    Friend(name = "Chris Hemsworth", isFollowing = false),
    Friend(name = "Anne Hathaway", isFollowing = false),
    Friend(name = "Ryan Reynolds", isFollowing = false)
)
