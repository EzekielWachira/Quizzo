package com.ezzy.quizzo.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.domain.model.Quiz
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun QuizItem(
    quiz: Quiz,
    onClick: (Quiz) -> Unit = {},
    modifier: Modifier = Modifier
) {


    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        shape = RoundedCornerShape(DpDimensions.Normal),
        onClick = { onClick(quiz) },
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(130.dp)
                    .paint(
                        painter = painterResource(id = quiz.image),
                        contentScale = ContentScale.FillBounds,
                        sizeToIntrinsics = true
                    ),
                contentAlignment = Alignment.BottomEnd
            ) {

                CustomPadding(
                    verticalPadding = DpDimensions.Small,
                    horizontalPadding = DpDimensions.Small
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                MaterialTheme.colorScheme.onPrimary,
                                RoundedCornerShape(DpDimensions.Small)
                            )
                            .clip(
                                RoundedCornerShape(DpDimensions.Small),
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        CustomPadding(
                            verticalPadding = DpDimensions.Smallest,
                            horizontalPadding = DpDimensions.Smallest
                        ) {
                            Text(
                                text = "${quiz.quizNo} Qs",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

            }

            CustomPadding(
                verticalPadding = DpDimensions.Normal, horizontalPadding = DpDimensions.Normal,
                modifier = Modifier.weight(1f)
            ) {

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = quiz.title,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.basicMarquee()
                    )

                    Spacer(modifier = Modifier.height(DpDimensions.Small))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = quiz.date,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondary,
                        )

                        Spacer(modifier = Modifier.width(DpDimensions.Small))

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.onSecondary, CircleShape)
                                .size(3.dp)
                        )

                        Spacer(modifier = Modifier.width(DpDimensions.Small))

                        Text(
                            text = "${quiz.playsCount} plays",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondary,
                        )
                    }

                    Spacer(modifier = Modifier.height(DpDimensions.Normal))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(id = quiz.author.avatar),
                            contentDescription = null,
                            modifier = Modifier
                                .size(DpDimensions.Dp30)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                        )

                        Spacer(modifier = Modifier.width(DpDimensions.Small))

                        Text(
                            text = quiz.author.name,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.inversePrimary,
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
fun QuizItemPreview() {
    QuizzoTheme {
        QuizItem(quiz = quizzes[0], modifier = Modifier.fillMaxWidth())
    }
}