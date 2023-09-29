package com.ezzy.quizzo.ui.screens.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezzy.data.repository.PreferenceRepository
import com.ezzy.quizzo.ui.screens.sign_up.state.AccountState
import com.ezzy.quizzo.ui.screens.sign_up.state.ProfileState
import com.ezzy.quizzo.ui.screens.sign_up.state.ProgressState
import com.ezzy.quizzo.utils.toSmallDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
): ViewModel() {

    private val _profileState = MutableStateFlow(ProfileState())
    private val _accountState = MutableStateFlow(AccountState())
    private val _progressState = MutableStateFlow(ProgressState())
    val progressState get() = _progressState.asStateFlow()
    val profileState get() = _profileState.asStateFlow()
    val accountState get() = _accountState.asStateFlow()

    fun onNameTextChange(name: String) {
        _profileState.update {
            profileState.value.copy(
                name = name
            )
        }
    }

    fun onProgress(progress: Float) {
        _progressState.update {
            progressState.value.copy(
                progress = progress
            )
        }
    }

    fun onDobChange(dob: Long) {
        _profileState.update {
            profileState.value.copy(
                dateOfBirth = dob.toSmallDate()
            )
        }
    }

    fun onPhoneChange(phone: String) {
        _profileState.update {
            profileState.value.copy(
                phone = phone
            )
        }
    }

    fun onCountryChange(country: String) {
        _profileState.update {
            profileState.value.copy(
                country = country
            )
        }
    }

    fun onAgeTextChange(age: String) {
        _profileState.update {
            profileState.value.copy(
                age = age
            )
        }
    }

    fun onEmailChange(email: String) {
        _accountState.update {
            accountState.value.copy(email =  email)
        }
    }

    fun onUserNameChange(username: String) {
        _accountState.update {
            accountState.value.copy(username =  username)
        }
    }

    fun onPasswordChange(password: String) {
        _accountState.update {
            accountState.value.copy(password =  password)
        }
    }

    fun onRememberMe(isChecked: Boolean) {
        _accountState.update {
            accountState.value.copy(rememberMe =  isChecked)
        }
    }

    fun saveIsLoggedIn(isLoggedIn: Boolean) {
        viewModelScope.launch {
            preferenceRepository.saveUserLoggedInStatus(isLoggedIn)
        }
    }
}