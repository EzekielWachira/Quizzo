package com.ezzy.quizzo.ui.screens.settings

import androidx.lifecycle.ViewModel
import com.ezzy.quizzo.ui.screens.settings.state.SwitchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(): ViewModel(){

    private var _switchState = MutableStateFlow(SwitchState())
    val switchState = _switchState.asStateFlow()

    fun onCheckChange(isChecked: Boolean) {
        _switchState.update {
            switchState.value.copy(isChecked = isChecked)
        }
    }

}