package com.ezzy.quizzo.ui.screens.premium

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.premium.components.BenefitsAppBar
import com.ezzy.quizzo.ui.screens.premium.model.PremiumPager
import com.ezzy.quizzo.ui.screens.premium.model.pagerItems
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.RoyalBlue65
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PremiumScreen(
    onNavigateBack: () -> Unit = {},
    isSystemInDarkTheme: Boolean,
    navController: NavController
) {

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme
    val coroutineScope = rememberCoroutineScope()


    val pagerState = rememberPagerState {
        pagerItems.size
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = RoyalBlue65,
            darkIcons = false
        )
    }

    Scaffold(
        topBar = {
            BenefitsAppBar(
                backIcon = R.drawable.close,
                modifier = Modifier.fillMaxWidth(),
                onBackClicked = onNavigateBack,
                iconTint = Color.White,
                iconsVisible = pagerState.currentPage == pagerItems.size - 2
            )
        },
        containerColor = RoyalBlue65
    ) { paddingValues ->

        Pager(
            pagerState = pagerState,
            navController = rememberNavController(),
            coroutineScope = coroutineScope,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(
    items: List<PremiumPager> = pagerItems,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController,
    coroutineScope: CoroutineScope
) {

    Column(
        modifier = modifier
            .padding(PaddingValues(horizontal = DpDimensions.Normal))
            .verticalScroll(rememberScrollState())
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            userScrollEnabled = false
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = DpDimensions.Normal),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = items[page].title.uppercase(Locale.getDefault()),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp30))

                when (page) {
                    0 -> PremiumBenefits(modifier = Modifier.fillMaxWidth())
                    1 -> FreeVsPremium(modifier = Modifier.fillMaxWidth())
                    2 -> ChoosePlan(modifier = Modifier.fillMaxWidth())
                    3 -> SelectPayment(modifier = Modifier.fillMaxWidth())
                    4 -> Congrats(modifier = Modifier.fillMaxWidth())
                }


            }

        }

        Spacer(modifier = Modifier.height(DpDimensions.Small))

        Button(
            onClick = {
                if (pagerState.currentPage != items.size) {
                    coroutineScope.launch {
                        withContext(Dispatchers.Main) {
                            pagerState.scrollToPage(
                                pagerState.currentPage + 1,
                                pageOffsetFraction = 0f
                            )
                        }
                    }
                } else navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = items[pagerState.currentPage].buttonText
                    .uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.height(DpDimensions.Dp20))
    }

}


@Preview
@Composable
fun PremiumScreenPreview() {
    QuizzoTheme {
        PremiumScreen(isSystemInDarkTheme = false, navController = rememberNavController())
    }
}