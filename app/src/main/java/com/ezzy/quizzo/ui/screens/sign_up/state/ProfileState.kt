package com.ezzy.quizzo.ui.screens.sign_up.state

data class ProfileState(
    val name: String = "",
    val dateOfBirth: String = "",
    val phone: String = "",
    val country: String = "",
    val age: String = "",
    val isValid: Boolean = name.isNotBlank() && dateOfBirth.isNotBlank() &&
            country.isNotBlank() && phone.isNotBlank() && age.isNotBlank()
)
