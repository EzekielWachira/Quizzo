package com.ezzy.quizzo.ui.screens.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.library.components.ButtonsSection
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun MyQuizzoScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier,
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            modifier = Modifier.padding(horizontal = DpDimensions.Normal)
        ) {

            item {
                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                ButtonsSection(
                    leftButtonText = stringResource(id = R.string.app_name),
                    rightButtonText = stringResource(id = R.string.collections)
                )
            }

        }

    }

}