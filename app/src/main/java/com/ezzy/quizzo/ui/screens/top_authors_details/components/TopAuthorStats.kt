package com.ezzy.quizzo.ui.screens.top_authors_details.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

class TopAuthorStats {
}


@Composable
fun TopAuthorStats(
    modifier: Modifier = Modifier,
    onQuizzoClick: () -> Unit = {},
    onPlaysClick: () -> Unit = {},
    onPlayersClick: () -> Unit = {},
    onCollectionsClick: () -> Unit = {},
    onFollowersClick: () -> Unit = {},
    onFollowingClick: () -> Unit = {},
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = DpDimensions.Normal)
        ) {

            Divider(color = MaterialTheme.colorScheme.outline)

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = RoundedCornerShape(DpDimensions.Small),
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f),
                    onClick = onQuizzoClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = DpDimensions.Small)
                    ) {
                        Text(
                            text = "265",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )

                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .height(80.dp)
                        .width(1.dp)
                )

                Surface(
                    shape = RoundedCornerShape(DpDimensions.Small),
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f),
                    onClick = onPlaysClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = DpDimensions.Small)
                    ) {
                        Text(
                            text = "34M",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )

                        Text(
                            text = stringResource(R.string.plays),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .height(80.dp)
                        .width(1.dp)
                )
                Surface(
                    shape = RoundedCornerShape(DpDimensions.Small),
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f),
                    onClick = onPlayersClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = DpDimensions.Small)
                    ) {
                        Text(
                            text = "233M",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )

                        Text(
                            text = stringResource(R.string.players),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }


            }

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Divider(color = MaterialTheme.colorScheme.outline)

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    shape = RoundedCornerShape(DpDimensions.Small),
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f),
                    onClick = onCollectionsClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = DpDimensions.Small)
                    ) {
                        Text(
                            text = "434",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )

                        Text(
                            text = stringResource(R.string.collections),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .height(80.dp)  //fill the max height
                        .width(1.dp)
                )

                Surface(
                    shape = RoundedCornerShape(DpDimensions.Small),
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f),
                    onClick = onFollowersClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = DpDimensions.Small)
                    ) {
                        Text(
                            text = "498.3K",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )

                        Text(
                            text = stringResource(R.string.followers),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

                Divider(
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .height(80.dp)
                        .width(1.dp)
                )
                Surface(
                    shape = RoundedCornerShape(DpDimensions.Small),
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.weight(1f),
                    onClick = onFollowersClick
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = DpDimensions.Small)
                    ) {
                        Text(
                            text = "345",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )

                        Text(
                            text = stringResource(R.string.following),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }

            }

            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Divider(color = MaterialTheme.colorScheme.outline)

        }
    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TopAuthorStatsPreview() {
    QuizzoTheme {
        TopAuthorStats(Modifier.fillMaxWidth())
    }
}