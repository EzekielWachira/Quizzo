package com.ezzy.quizzo.ui.screens.sign_up

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.ui.common.CommonFadedButton
import com.ezzy.quizzo.ui.screens.sign_up.components.AccountTypeItem
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun WorkPlaceScreen(navController: NavController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(DpDimensions.Normal)
            ) {

//                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = stringResource(id = R.string.describe_workplace),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    lineHeight = 40.sp
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))


                Text(
                    text = stringResource(id = R.string.skip_it),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp30))

                LazyColumn(verticalArrangement = Arrangement.spacedBy(DpDimensions.Normal)) {
                    items(workplaces, key = { type -> type.title }) { accountType->
                        AccountTypeItem(
                            accountType = accountType,
                        )
                    }
                }

            }

            CommonFadedButton(label = stringResource(R.string.skip),
                modifier = Modifier.fillMaxWidth(),
                onClick = {
//                    navController.navigate(NavDestinations.SignupSteps.WORKPLACE)
                })

        }


    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WorkPlaceScreenPreview() {
    QuizzoTheme {
        WorkPlaceScreen(rememberNavController())
    }
}