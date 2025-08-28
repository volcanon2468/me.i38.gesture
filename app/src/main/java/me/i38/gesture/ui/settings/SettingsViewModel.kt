package me.i38.gesture.ui.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.repository.GestureRepository
import me.i38.gesture.utils.PermissionManager
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gestureRepository: GestureRepository,
    private val permissionManager: PermissionManager
) : ViewModel() {

    data class SettingsUiState(
        val gestures: List<GestureConfig> = emptyList(),
        val vibrateIntensity: Int = 10,
        val isToastFeedbackEnabled: Boolean = true,
        val hasAccessibilityPermission: Boolean = false,
        val hasOverlayPermission: Boolean = false,
        val hasWriteSettingsPermission: Boolean = false,
        val isLoading: Boolean = false,
        val errorMessage: String? = null
    )

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        loadData()
        checkPermissions()
    }

    private fun loadData() {
        viewModelScope.launch {
            gestureRepository.getAllGestures().collect { gestures ->
                _uiState.update { currentState ->
                    currentState.copy(
                        gestures = gestures,
                        vibrateIntensity = gestureRepository.getVibrateIntensity(),
                        isToastFeedbackEnabled = gestureRepository.isToastFeedbackEnabled()
                    )
                }
            }
        }
    }

    private fun checkPermissions() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(
                    hasAccessibilityPermission = permissionManager.hasAccessibilityPermission(),
                    hasOverlayPermission = permissionManager.hasOverlayPermission(),
                    hasWriteSettingsPermission = permissionManager.hasWriteSettingsPermission()
                )
            }
        }
    }

    fun addNewGesture() {
        viewModelScope.launch {
            try {
                val newGesture = GestureConfig(
                    axis = 1,
                    direction = 1,
                    count = 1,
                    threshold = 10,
                    action = "1"
                )
                gestureRepository.insertGesture(newGesture)
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Failed to add gesture") }
            }
        }
    }

    fun toggleGesture(gestureId: Long, enabled: Boolean) {
        viewModelScope.launch {
            try {
                val gesture = gestureRepository.getGestureById(gestureId)
                if (gesture != null) {
                    gestureRepository.updateGesture(gesture.copy(isEnabled = enabled))
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Failed to update gesture") }
            }
        }
    }

    fun setVibrateIntensity(intensity: Int) {
        viewModelScope.launch {
            try {
                gestureRepository.setVibrateIntensity(intensity)
                _uiState.update { it.copy(vibrateIntensity = intensity) }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Failed to update vibrate intensity") }
            }
        }
    }

    fun setToastFeedbackEnabled(enabled: Boolean) {
        viewModelScope.launch {
            try {
                gestureRepository.setToastFeedbackEnabled(enabled)
                _uiState.update { it.copy(isToastFeedbackEnabled = enabled) }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Failed to update toast feedback") }
            }
        }
    }

    fun showVibrateIntensityDialog() {
        // Show dialog to adjust vibrate intensity
    }

    fun requestAccessibilityPermission() {
        try {
            val intent = permissionManager.requestAccessibilityPermission()
            context.startActivity(intent)
        } catch (e: Exception) {
            _uiState.update { it.copy(errorMessage = "Failed to open accessibility settings") }
        }
    }

    fun requestOverlayPermission() {
        try {
            val intent = permissionManager.requestOverlayPermission()
            context.startActivity(intent)
        } catch (e: Exception) {
            _uiState.update { it.copy(errorMessage = "Failed to open overlay settings") }
        }
    }

    fun requestWriteSettingsPermission() {
        try {
            val intent = permissionManager.requestWriteSettingsPermission()
            context.startActivity(intent)
        } catch (e: Exception) {
            _uiState.update { it.copy(errorMessage = "Failed to open write settings") }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}