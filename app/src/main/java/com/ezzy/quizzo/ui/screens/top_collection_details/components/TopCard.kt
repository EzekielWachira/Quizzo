package com.ezzy.quizzo.ui.screens.top_collection_details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.RoyalBlue65

@Composable
fun TopCard(modifier: Modifier = Modifier) {

    Surface(
        shape = RoundedCornerShape(DpDimensions.Dp20),
        color = RoyalBlue65,
        modifier = modifier.height(150.dp)
    ) {

        Box(
            modifier = Modifier.paint(
                painter = painterResource(id = R.drawable.shelf_2),
                contentScale = ContentScale.Crop
            ), contentAlignment = Alignment.Center
        ) {
        }
    }

}