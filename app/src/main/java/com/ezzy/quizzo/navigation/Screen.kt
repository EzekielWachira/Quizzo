package com.ezzy.quizzo.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ezzy.quizzo.R

sealed class Screen(val route: String, @StringRes val label: Int, @DrawableRes val icon: Int) {
    object Home: Screen(HOME, R.string.home, R.drawable.home)
    object Libary: Screen(LIBRARY, R.string.library, R.drawable.grid)
    object Join: Screen(JOIN, R.string.join, R.drawable.quiz_24)
    object Create: Screen(CREATE, R.string.add, R.drawable.add)
    object Profile: Screen(PROFILE, R.string.profile, R.drawable.profile)

    companion object {
        const val HOME = "home"
        const val LIBRARY = "library"
        const val JOIN = "join"
        const val CREATE = "create"
        const val PROFILE = "profile"
    }
}

val bottomNavigationScreens = listOf(
    Screen.Home,
    Screen.Libary,
    Screen.Join,
    Screen.Create,
    Screen.Profile
)
