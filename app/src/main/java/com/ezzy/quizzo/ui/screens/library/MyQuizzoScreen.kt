package com.ezzy.quizzo.ui.screens.library

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.quizzes
import com.ezzy.quizzo.ui.common.CustomTab
import com.ezzy.quizzo.ui.common.HeaderWithSort
import com.ezzy.quizzo.ui.common.QuizItem
import com.ezzy.quizzo.ui.screens.home.collections
import com.ezzy.quizzo.ui.screens.home.components.CollectionItem
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyQuizzoScreen(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit = {}
) {

    val tabTitles = listOf(
        stringResource(id = R.string.app_name),
        stringResource(id = R.string.collections),
    )

    var selectedTabIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        floatingActionButton = {
            if (selectedTabIndex == 1) {

                FloatingActionButton(
                    onClick = { },
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_btn),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(DpDimensions.Dp20)
                    )
                }
            } else {
            }
        }
    ) {
        Box(
            modifier = modifier,
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = DpDimensions.Normal)
            ) {
                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                CustomTab(
                    selectedIndex = selectedTabIndex,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { index -> selectedTabIndex = index },
                    tabTitles = tabTitles
                )

                HeaderWithSort(
                    title = when (selectedTabIndex) {
                        0 -> "45 Quizzo"
                        1 -> "7 Collections"
                        else -> ""
                    }, modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(DpDimensions.Small))


                when (selectedTabIndex) {
                    0 -> {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            items(quizzes.take(10)) { quiz ->
                                QuizItem(quiz = quiz, modifier = Modifier.fillMaxWidth(),
                                    onClick = {
                                        onItemClick()
                                    })
                            }

                            item {
                                Spacer(modifier = Modifier.height(DpDimensions.Dp50))
                            }
                        }

                    }

                    1 -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
                            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
                        ) {
                            items(collections) { collection ->
                                CollectionItem(
                                    collection = collection,
                                    onClick = {
                                        onItemClick()
                                    }, modifier = Modifier.fillMaxWidth(),
                                    height = 150.dp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(DpDimensions.Dp50))

                    }
                }


            }

        }
    }


}

@Preview
@Composable
fun MyQuizzoScreenPreview() {
    QuizzoTheme {
        MyQuizzoScreen(Modifier.fillMaxSize())
    }
}