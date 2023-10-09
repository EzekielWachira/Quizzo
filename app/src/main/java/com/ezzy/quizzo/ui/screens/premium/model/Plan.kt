package com.ezzy.quizzo.ui.screens.premium.model

data class Plan(
    val timeSpan: String,
    val description: String,
    val amount: String
)

val plans = listOf(
    Plan("1 Month", "Get over 5% off", "$10.00"),
    Plan("2 Month", "Get over 10% off", "$18.00"),
    Plan("3 Month", "Get over 15% off", "$26.00"),
    Plan("6 Month", "Get over 20%", "$44.00"),
    Plan("12 Month", "Get over 25% off", "$62.00"),
)
