package com.ezzy.quizzo.ui.screens.premium

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.premium.components.FreeVsPremiumItem
import com.ezzy.quizzo.ui.screens.premium.model.differences
import com.ezzy.quizzo.ui.theme.DpDimensions
import java.util.Locale

@Composable
fun Congrats(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(DpDimensions.Normal),
        color = Color.Transparent,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.congrats),
                contentDescription = null,
                modifier = Modifier.height(350.dp)
            )

            Spacer(modifier = Modifier.height(DpDimensions.Dp30))

            Text(
                text = stringResource(R.string.congrats),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))

            Text(
                text = stringResource(R.string.welcome_to_premium),
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(DpDimensions.Dp20))

        }
    }
}