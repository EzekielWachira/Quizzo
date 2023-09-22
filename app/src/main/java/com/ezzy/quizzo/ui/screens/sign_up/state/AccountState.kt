package com.ezzy.quizzo.ui.screens.sign_up.state

import com.ezzy.quizzo.utils.isValidEmail
import com.ezzy.quizzo.utils.isValidPassword
import com.ezzy.quizzo.utils.isValidUsername

data class AccountState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val isValid: Boolean = username.isNotBlank() &&
            (email.isNotBlank() && email.isValidEmail()) &&
            (password.isNotBlank() && password.isValidPassword()),
    val isUsernameValid: Boolean = username.isNotBlank() && username.isValidUsername()
)
