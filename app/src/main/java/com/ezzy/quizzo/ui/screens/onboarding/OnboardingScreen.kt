package com.ezzy.quizzo.ui.screens.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.navigation.utils.NavDestinations.Auth.SIGN_UP
import com.ezzy.quizzo.ui.screens.onboarding.components.ButtonsSection
import com.ezzy.quizzo.ui.screens.onboarding.components.PagerIndicator
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState {
        onBoardingItems.size
    }

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }


    OnboardingPager(
        pagerState = pagerState, navController = navController,
        modifier = Modifier.fillMaxSize()
    )


}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnboardingScreenPreview() {
    QuizzoTheme {
        OnboardingScreen(rememberNavController())
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(
    items: List<OnBoarding> = onBoardingItems,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val coroutineScope = rememberCoroutineScope()


    Scaffold { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(DpDimensions.Normal),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Image(
                            painter = painterResource(id = items[page].image),
                            contentDescription = stringResource(
                                id = items[page].title
                            ),
                            modifier = Modifier.size(250.dp)
                        )

                        Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                        Text(
                            text = stringResource(id = items[page].title),
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.inversePrimary,
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            lineHeight = 40.sp
                        )

                    }


                }
            }

            PagerIndicator(currentPage = pagerState.currentPage, items = items)

            Spacer(modifier = Modifier.height(DpDimensions.Dp30))

            ButtonsSection(
                modifier = Modifier.fillMaxWidth(),
                onGetStartedClick = { navController.navigate(SIGN_UP) },
                onHaveAccountClick = { }
            )
        }

    }


}