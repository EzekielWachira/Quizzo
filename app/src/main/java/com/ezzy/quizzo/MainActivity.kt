package com.ezzy.quizzo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.ui.screens.main.MainScreen
import com.ezzy.quizzo.ui.screens.onboarding.OnboardingScreen
import com.ezzy.quizzo.ui.screens.sign_up.SignupStepsScreen
import com.ezzy.quizzo.ui.screens.splash_screen.SplashMain
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.RoyalBlue65
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizzoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        SplashMain()
                    }
                }
            }
        }
    }
}

@Composable
fun QRCodeBorder() {
    val boxSize = 200.dp
    Box(modifier = Modifier.size(boxSize)) {
        val infiniteTransition = rememberInfiniteTransition(label = "")
        val dpToPx = with(LocalDensity.current) { boxSize.toPx() }
        val animatedOffset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = dpToPx,
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )
        Canvas(modifier = Modifier
            .matchParentSize()
            .clip(RoundedCornerShape(3.dp))) {
            val strokeWidth = 10f
            val halfStrokeWidth = strokeWidth / 2
            val cornerSize = 50f // Adjust this to change the size of the corners

            // Top-left corner
            drawLine(
                color = RoyalBlue65,
                start = Offset(0f, halfStrokeWidth),
                end = Offset(cornerSize, halfStrokeWidth),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = RoyalBlue65,
                start = Offset(halfStrokeWidth, 0f),
                end = Offset(halfStrokeWidth, cornerSize),
                strokeWidth = strokeWidth
            )

            // Top-right corner
            drawLine(
                color = RoyalBlue65,
                start = Offset(size.width, halfStrokeWidth),
                end = Offset(size.width - cornerSize, halfStrokeWidth),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = RoyalBlue65,
                start = Offset(size.width - halfStrokeWidth, halfStrokeWidth),
                end = Offset(size.width - halfStrokeWidth, cornerSize),
                strokeWidth = strokeWidth
            )

            // Bottom-right corner
            drawLine(
                color = RoyalBlue65,
                start = Offset(size.width , size.height - halfStrokeWidth),
                end = Offset(size.width - cornerSize, size.height - halfStrokeWidth),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = RoyalBlue65,
                start = Offset(size.width - halfStrokeWidth, size.height - halfStrokeWidth),
                end = Offset(size.width - halfStrokeWidth, size.height - cornerSize),
                strokeWidth = strokeWidth
            )

            // Bottom-left corner
            drawLine(
                color = RoyalBlue65,
                start = Offset(halfStrokeWidth, size.height - halfStrokeWidth),
                end = Offset(cornerSize, size.height - halfStrokeWidth),
                strokeWidth = strokeWidth
            )
            drawLine(
                color = RoyalBlue65,
                start = Offset(halfStrokeWidth, size.height),
                end = Offset(halfStrokeWidth, size.height - cornerSize),
                strokeWidth = strokeWidth
            )


            drawLine(
                color = RoyalBlue65,
                start = Offset(0f, animatedOffset),
                end = Offset(size.width, animatedOffset),
                strokeWidth = 4f
            )
        }
        // Your QR Code composable goes here
    }
}

@Composable
fun GetStartedButton() {
    Button(
        onClick = { /* Do something when button is clicked */ },
        shape = RoundedCornerShape(16.dp), // Adjust corner radius as needed
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)), // Replace with your desired color
        modifier = Modifier.shadow(4.dp, RoundedCornerShape(16.dp)) // Add shadow
    ) {
        Text(
            text = "GET STARTED",
            color = Color.White,
//            style = MaterialTheme.typography.button
        )
    }
}


@Preview
@Composable
fun QRCodeBorderPreview() {
    QuizzoTheme {
        QRCodeBorder()
    }
}


