package com.ezzy.quizzo.ui.screens.playground

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun InstagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(x = size.width * .80f, y = size.height * .20f)
        )
    }
}

@Composable
fun FacebookIcon() {
    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
        typeface = Typeface.DEFAULT
    }

    Canvas(modifier = Modifier
        .size(100.dp)
        .padding(16.dp)) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f)
        )

        drawContext.canvas.nativeCanvas.drawText("f", center.x + 25, center.y + 90, paint )
    }
}

@Composable
fun messengerIcon() {
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        val trianglePath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .77f)
            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
            it.close()
            it
        }

        val electricPath = Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * 0.60f)
            it.lineTo(this.size.width * .45f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
            it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
            it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
            it.close()
            it
        }

        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height * 0.95f)
        )

        drawPath(
            path = trianglePath,
            Brush.verticalGradient(colors = colors),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawPath(path = electricPath, color = Color.White)

    }
}

@Composable
private fun getGooglePhotosIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawArc(
            color = Color(0xFFf04231),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, 0f)
        )
        drawArc(
            color = Color(0xFF4385f7),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .50f, size.height * .25f)
        )
        drawArc(
            color = Color(0xFF30a952),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(0f, size.height * .25f)
        )

        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 270f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.height * .50f)
        )


    }
}

@Composable
fun getWeatherApp() {
    val backgroundColor = listOf(Color(0xFF2078EE), Color(0xFF74E6FE))
    val sunColor = listOf(Color(0xFFFFC200), Color(0xFFFFE100))
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(width.times(.76f), height.times(.72f))
            cubicTo(
                width.times(.93f),
                height.times(.72f),
                width.times(.98f),
                height.times(.41f),
                width.times(.76f),
                height.times(.40f)
            )
            cubicTo(
                width.times(.75f),
                height.times(.21f),
                width.times(.35f),
                height.times(.21f),
                width.times(.38f),
                height.times(.50f)
            )
            cubicTo(
                width.times(.25f),
                height.times(.50f),
                width.times(.20f),
                height.times(.69f),
                width.times(.41f),
                height.times(.72f)
            )
            close()
        }
        drawRoundRect(
            brush = Brush.verticalGradient(backgroundColor),
            cornerRadius = CornerRadius(50f, 50f),

            )
        drawCircle(
            brush = Brush.verticalGradient(sunColor),
            radius = width.times(.17f),
            center = Offset(width.times(.35f), height.times(.35f))
        )
        drawPath(path = path, color = Color.White.copy(alpha = .90f))
    }
}


@Composable
fun GreenCapsule(
    width: Dp,
    height: Dp
) {
    val radius = 50f
    Canvas(
        modifier = Modifier
            .height(height)
            .width(width)
    ) {
        drawCircle(
            center = center,
            radius = radius,
            color = Color.Green
        )

        drawArc(
            startAngle = 0f,
            sweepAngle = 180f,

            color = Color.White,
            useCenter = true
        )

        drawArc(
            startAngle = 180f,
            sweepAngle = 180f,

            color = Color.White,
            useCenter = true
        )

        drawPath(
            path = Path().apply {
                moveTo(center.x - radius / 2, center.y - radius)
                lineTo(center.x + radius / 2, center.y - radius)
                lineTo(center.x, center.y)
                close()
            },
            color = Color.Green.copy(alpha = 0.8f)
        )
    }
}


@Composable
fun CapsuleCanvas() {
    Canvas(modifier = Modifier.size(200.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        // Draw the gray part of the capsule
        drawRoundRect(
            color = Color.Gray,
            topLeft = Offset(x = 0f, y = 0f),
            size = Size(width = canvasWidth, height = canvasHeight * 0.6f),
            cornerRadius = CornerRadius(x = canvasWidth / 2, y = canvasWidth / 2)
        )

        // Draw the yellow part of the capsule
        drawRoundRect(
            color = Color.Yellow,
            topLeft = Offset(x = 0f, y = canvasHeight * 0.4f),
            size = Size(width = canvasWidth, height = canvasHeight * 0.6f),
            cornerRadius = CornerRadius(x = canvasWidth / 2, y = canvasWidth / 2)
        )
    }
}

@Preview
@Composable
fun MyPrebiew() {
    getWeatherApp()
}