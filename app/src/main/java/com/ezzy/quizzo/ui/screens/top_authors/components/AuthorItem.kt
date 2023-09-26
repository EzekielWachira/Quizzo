package com.ezzy.quizzo.ui.screens.top_authors.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.home.Author
import com.ezzy.quizzo.ui.screens.home.authors
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AuthorItem(
    author: Author,
    modifier: Modifier = Modifier,
    onClick: (author: Author) -> Unit = {},
    onFollowClick: (author: Author) -> Unit = {},
    onUnFollowClick: (author: Author) -> Unit = {},
) {

    Surface(
        modifier = modifier,
        onClick = { onClick(author) },
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = DpDimensions.Small),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = author.avatar),
                contentDescription = null,
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Crop
            )


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = DpDimensions.Small),
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Smallest)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
                ) {
                    Text(
                        text = author.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )

                    if (author.isVerified) {
                        Image(
                            painter = painterResource(id = R.drawable.verified),
                            contentDescription = "Verified icon",
                            modifier = Modifier.size(DpDimensions.Dp20)
                        )
                    }
                }

                Text(
                    text = author.username,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }

            if (author.isFollowing) {
                Button(
                    onClick = {
                        onFollowClick(author)
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

            } else {
                OutlinedButton(
                    onClick = { onUnFollowClick(author) },
                    modifier = Modifier.height(35.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimary)
                ) {
                    Text(
                        text = stringResource(R.string.following),
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AuthorItemPreview() {
    QuizzoTheme {
        AuthorItem(authors[1], modifier = Modifier.fillMaxWidth())
    }
}