package com.ezzy.quizzo.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationVector
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel

private val DarkColorScheme = darkColorScheme(
    primary = RoyalBlue65,
    secondary = RoyalBlue65,
    tertiary = Color.White,
    background = DarkGrey11,
    inversePrimary = Color.White,
    secondaryContainer = DarkSlateBlue14,
    outline = DarkSlateBlue23,
    onPrimary = RoyalBlue65,
    onSecondary = Grey88,
    onSecondaryContainer = BlueGray23,
    onTertiaryContainer = Color.White,
    onSurface = BlueGrey15,
    surfaceVariant = BlueGrey15,
    inverseSurface = Grey46
)

private val LightColorScheme = lightColorScheme(
    primary = RoyalBlue65,
    secondary = RoyalBlue65,
    tertiary = RoyalBlue65,
    background = Color.White,
    inversePrimary = DarkGrey13,
    secondaryContainer = OffWhite98,
    outline = LightGrey94,
    onPrimary = RoyalBlue65,
    onSecondary = Grey26,
    onSecondaryContainer = Lavender96,
    onTertiaryContainer = Color.Black,
    onSurface = Grey96,
    surfaceVariant = Color.White,
    inverseSurface = Grey75

)

@Composable
fun QuizzoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val viewModel: SettingsViewModel = hiltViewModel()
    val isDarkTheme = viewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)


    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        isDarkTheme.value -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography.copy(
            headlineLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = SpDimensions.HeadlineLarge,
                lineHeight = 28.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.inversePrimary
            ),
            bodyLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = SpDimensions.BodyLarge,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.onSecondary
            ),
            bodyMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = SpDimensions.BodyMedium,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.onSecondary
            ),
            bodySmall = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = SpDimensions.BodySmall,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.onSecondary
            ),
            titleMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = SpDimensions.TitleMedium,
                lineHeight = 22.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.inversePrimary
            ),
            titleLarge = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = SpDimensions.TitleLarge,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.inversePrimary
            ),
            headlineMedium = TextStyle(
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = SpDimensions.HeadlineMedium,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                color = MaterialTheme.colorScheme.inversePrimary
            )
        ),
        content = content
    )
}