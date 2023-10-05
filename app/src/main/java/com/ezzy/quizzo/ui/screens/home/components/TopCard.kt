package com.ezzy.quizzo.ui.screens.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.RoyalBlue65

@Composable
fun TopCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {}
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Dp20),
        color = RoyalBlue65,
        modifier = modifier.height(170.dp)
    ) {

        Box(modifier = Modifier.paint(
            painter = painterResource(id = R.drawable.background),
            contentScale = ContentScale.Crop
        ), contentAlignment = Alignment.Center) {

            Column(
                modifier = Modifier.padding(DpDimensions.Normal)
                    .fillMaxWidth()
            ) {

                Text(
                    text = stringResource(R.string.play_quiz_together),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {

                    Text(
                        text = stringResource(R.string.find_friends),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                }

            }
        }

    }

}


@Composable
fun TopCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    title: String,
    buttonText: String,
    @DrawableRes image: Int
) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Dp20),
        color = RoyalBlue65,
        modifier = modifier.height(170.dp)
    ) {

        Box(modifier = Modifier.paint(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop
        ), contentAlignment = Alignment.Center) {

            Column(
                modifier = Modifier.padding(DpDimensions.Normal)
                    .fillMaxWidth()
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {

                    Text(
                        text = buttonText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                }

            }
        }

    }

}

@Preview
@Composable
fun TopCardPreview() {
    QuizzoTheme {
        TopCard(modifier = Modifier.fillMaxWidth())
    }
}