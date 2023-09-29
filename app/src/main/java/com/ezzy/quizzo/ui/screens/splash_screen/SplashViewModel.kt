package com.ezzy.quizzo.ui.screens.splash_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezzy.data.repository.PreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {

    val isLoggedIn = preferenceRepository.isUserLoggedIn

    fun saveIsLoggedIn(isLoggedIn: Boolean) {
        viewModelScope.launch {
            preferenceRepository.saveUserLoggedInStatus(isLoggedIn)
        }
    }

}