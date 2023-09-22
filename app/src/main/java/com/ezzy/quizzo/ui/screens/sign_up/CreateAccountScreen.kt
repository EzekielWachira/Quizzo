package com.ezzy.quizzo.ui.screens.sign_up

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.navigation.utils.NavDestinations
import com.ezzy.quizzo.ui.common.CommonDatePickerDialog
import com.ezzy.quizzo.ui.common.CommonFadedButton
import com.ezzy.quizzo.ui.screens.sign_up.components.AgeTexfield
import com.ezzy.quizzo.ui.screens.sign_up.components.CountryTexfield
import com.ezzy.quizzo.ui.screens.sign_up.components.DobTexfield
import com.ezzy.quizzo.ui.screens.sign_up.components.NameTexfield
import com.ezzy.quizzo.ui.screens.sign_up.components.PhoneTexfield
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun CreateAccountScreen(navController: NavController) {

    val viewModel: SignUpViewModel = hiltViewModel()
    val profileState by viewModel.profileState.collectAsStateWithLifecycle()
    var isDatePickerOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = DpDimensions.Normal)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                Text(
                    text = stringResource(id = R.string.create_account),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    lineHeight = 40.sp
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))


                Text(
                    text = stringResource(id = R.string.complete_profile),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                NameTexfield(
                    state = profileState, modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onNameTextChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                DobTexfield(
                    state = profileState, modifier = Modifier.fillMaxWidth(),
                    onCalendarIconClick = {
                        isDatePickerOpen = !isDatePickerOpen
                    }
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                PhoneTexfield(
                    state = profileState, modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onPhoneChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                CountryTexfield(
                    state = profileState, modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onCountryChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                AgeTexfield(
                    state = profileState, modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onAgeTextChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp30))
            }

            CommonFadedButton(
                label = stringResource(R.string.continue_),
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(NavDestinations.SignupSteps.CREATE_ACCOUNT_2)
                },
                containerColor = MaterialTheme.colorScheme.onPrimary,
                textColor = Color.White
            )
        }

        if (isDatePickerOpen) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CommonDatePickerDialog(openDialog = isDatePickerOpen, title = "Select date",
                    onDismiss = { isDatePickerOpen = false },
                    onDateSelected = { isOpen, selectedDate ->
                        isDatePickerOpen = isOpen

                        if (selectedDate != null) {
                            viewModel.onDobChange(selectedDate)
                        }
                    })
            }
        }
    }


}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CreateAccountScreenPreview() {
    QuizzoTheme {
        CreateAccountScreen(rememberNavController())
    }
}