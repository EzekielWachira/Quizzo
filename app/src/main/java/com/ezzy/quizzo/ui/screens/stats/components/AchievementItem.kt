package com.ezzy.quizzo.ui.screens.stats.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.ui.screens.stats.Achievement
import com.ezzy.quizzo.ui.screens.stats.achievements
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun AchievementItem(
    modifier: Modifier = Modifier,
    achievement: Achievement
) {

    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DpDimensions.Small, vertical = DpDimensions.Normal),
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {

            Image(
                painter = painterResource(id = achievement.icon), contentDescription = null,
                modifier = Modifier.size(DpDimensions.Dp30)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = achievement.value,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )

                Spacer(modifier = Modifier.height(DpDimensions.Smallest))

                Text(
                    text = achievement.name,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }

        }

    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AchievementItemPreview() {
    QuizzoTheme {
        AchievementItem(achievement = achievements[1])
    }
}