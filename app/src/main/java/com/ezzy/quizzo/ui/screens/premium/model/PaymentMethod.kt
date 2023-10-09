package com.ezzy.quizzo.ui.screens.premium.model

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class PaymentMethod(
    val name: String,
    val isChecked: Boolean = false,
    @DrawableRes val paymentIcon: Int
)

val paymentMethods = listOf(
    PaymentMethod(name = "PayPal",  isChecked = false, paymentIcon = R.drawable.paypal),
    PaymentMethod(name = "Google Pay",  isChecked = false, paymentIcon = R.drawable.google_pay),
    PaymentMethod(name = "Apple Pay",  isChecked = false, paymentIcon = R.drawable.apple_pay),
    PaymentMethod(name = "**** **** 2736",  isChecked = true, paymentIcon = R.drawable.mastercard),
    PaymentMethod(name = "**** **** 4653",  isChecked = false, paymentIcon = R.drawable.visa),
)