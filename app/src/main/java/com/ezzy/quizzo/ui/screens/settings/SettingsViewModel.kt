package com.ezzy.quizzo.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezzy.data.repository.PreferenceRepository
import com.ezzy.quizzo.ui.screens.settings.state.SwitchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
): ViewModel(){

    private var _switchState = MutableStateFlow(SwitchState())
    val switchState = _switchState.asStateFlow()

    val isDarkModeEnabled = preferenceRepository.isDarkModeEnabled

    fun onCheckChange(isChecked: Boolean) {
        _switchState.update {
            switchState.value.copy(isChecked = isChecked)
        }
    }

    fun setDarkModel(isSet: Boolean) {
        viewModelScope.launch {
            preferenceRepository.setDarkMode(isSet)
        }
    }

}