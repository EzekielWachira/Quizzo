package com.ezzy.quizzo.ui.screens.sign_up

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import com.ezzy.quizzo.ui.common.CommonFadedButton
import com.ezzy.quizzo.ui.common.SocialAccountButton
import com.ezzy.quizzo.ui.common.SocialAccountButton2
import com.ezzy.quizzo.ui.screens.sign_up.components.EmailTexfield
import com.ezzy.quizzo.ui.screens.sign_up.components.OrDivider
import com.ezzy.quizzo.ui.screens.sign_up.components.PasswordTexfield
import com.ezzy.quizzo.ui.screens.sign_up.components.RememberMe
import com.ezzy.quizzo.ui.screens.sign_up.components.UsernameTexfield
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun UsernameScreen(navController: NavController, viewModel: SignUpViewModel) {
    val accountState by viewModel.accountState.collectAsStateWithLifecycle()

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
                    text = stringResource(id = R.string.enter_your_user_name),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                UsernameTexfield(
                    state = accountState, modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onUserNameChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                EmailTexfield(
                    state = accountState,
                    modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onEmailChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                PasswordTexfield(
                    state = accountState,
                    modifier = Modifier.fillMaxWidth(),
                    onTextChange = viewModel::onPasswordChange
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                RememberMe(
                    state = accountState, modifier = Modifier.fillMaxWidth(),
                    onCheckChange = viewModel::onRememberMe
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                OrDivider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                SocialAccountButton(label = stringResource(R.string.continue_with_google),
                    image = R.drawable.google,
                    modifier = Modifier.fillMaxWidth(),
                    onButtonClick = { }
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp20))

                SocialAccountButton2(label = stringResource(R.string.continue_with_apple),
                    image = R.drawable.apple,
                    modifier = Modifier.fillMaxWidth(),
                    onButtonClick = {}
                )

                Spacer(modifier = Modifier.height(DpDimensions.Dp30))

            }

            CommonFadedButton(
                label = stringResource(R.string.sign_up),
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(NavDestinations.MAIN_APP) {
                        popUpTo(NavDestinations.SignupSteps.SIGNUP_STEPS) {
                            inclusive = true
                        }
                    }.also {
                        viewModel.saveIsLoggedIn(true)
                    }
                },
                containerColor = MaterialTheme.colorScheme.onPrimary,
                textColor = Color.White
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun UsernameScreenPreview() {
    QuizzoTheme {
        UsernameScreen(rememberNavController(), hiltViewModel())
    }
}