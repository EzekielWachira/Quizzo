package com.ezzy.quizzo.ui.screens.library.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.Quiz
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.common.CustomPadding
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun CollaboratorItem(
    quiz: Quiz,
    onClick: (Quiz) -> Unit = {},
    modifier: Modifier = Modifier
) {

    val images = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,
        R.drawable.person_5
    )

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
                    .width(120.dp)
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
//                        modifier = Modifier.basicMarquee()
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

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CustomImage(image = images.random())
                            CustomImage(image = images.random(), modifier = Modifier.offset(x = (-10).dp))
                            CustomImage(image = images.random(), modifier = Modifier.offset(x = (-20).dp) )
                            CustomImage(image = images.random(), modifier = Modifier.offset(x = (-30).dp) )
                            CustomImage(image = images.random(), modifier = Modifier.offset(x = (-40).dp) )
                            CustomImage(image = images.random(), modifier = Modifier.offset(x = (-50).dp) )
                        }



                        Text(
                            text = quiz.author.name,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.inversePrimary,
                            modifier = Modifier.offset(x = (-40).dp).basicMarquee()
                                .weight(1f),
                            maxLines = 1
                        )
                    }
                }

            }
        }

    }
}


@Composable
fun CustomImage(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier.size(DpDimensions.Dp24)
            .clip(CircleShape)
            .border(border = BorderStroke(1.dp, color = Color.White), CircleShape),
        contentScale = ContentScale.Crop,
    )
}


@Preview
@Composable
fun CollaboratorItemPreview() {
    QuizzoTheme {
        CollaboratorItem(
            quiz = quizzes[0], modifier = Modifier.fillMaxWidth()
        )
    }
}