package com.ezzy.quizzo.ui.screens.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.common.HeaderWithSort
import com.ezzy.quizzo.ui.common.QuizItem
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun FavoritesScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(DpDimensions.Small))
        HeaderWithSort(title = "28 Favorites")
        
        Spacer(modifier = Modifier.height(DpDimensions.Smallest))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(quizzes.take(10)) { quiz ->
                QuizItem(quiz = quiz, modifier = Modifier.fillMaxWidth(),
                    onClick = {})
            }

            item {
                Spacer(modifier = Modifier.height(DpDimensions.Dp50))
            }
        }
        
    }
    
}