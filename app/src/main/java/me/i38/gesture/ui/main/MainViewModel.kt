package me.i38.gesture.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.repository.GestureRepository
import me.i38.gesture.utils.GestureDetector
import me.i38.gesture.utils.PermissionManager
import me.i38.gesture.utils.SensorHelper
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gestureRepository: GestureRepository,
    private val gestureDetector: GestureDetector,
    private val permissionManager: PermissionManager,
    private val sensorHelper: SensorHelper
) : ViewModel() {

    data class MainUiState(
        val isMainSwitchEnabled: Boolean = false,
        val isGestureDetectionActive: Boolean = false,
        val hasAccessibilityPermission: Boolean = false,
        val hasGyroscope: Boolean = false,
        val gestures: List<GestureConfig> = emptyList(),
        val isLoading: Boolean = false,
        val errorMessage: String? = null
    )

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        observeData()
        checkPermissions()
        checkSensorAvailability()
    }

    private fun observeData() {
        viewModelScope.launch {
            combine(
                gestureRepository.getEnabledGestures(),
                flowOf(gestureRepository.isMainSwitchEnabled())
            ) { gestures, isMainSwitchEnabled ->
                _uiState.update { currentState ->
                    currentState.copy(
                        gestures = gestures,
                        isMainSwitchEnabled = isMainSwitchEnabled,
                        isGestureDetectionActive = gestureDetector.isDetectionEnabled()
                    )
                }
            }.collect()
        }
    }

    private fun checkPermissions() {
        viewModelScope.launch {
            val hasAccessibility = permissionManager.hasAccessibilityPermission()
            _uiState.update { it.copy(hasAccessibilityPermission = hasAccessibility) }
        }
    }

    private fun checkSensorAvailability() {
        viewModelScope.launch {
            val hasGyroscope = sensorHelper.hasGyroscope()
            _uiState.update { it.copy(hasGyroscope = hasGyroscope) }
        }
    }

    fun toggleMainSwitch(enabled: Boolean) {
        viewModelScope.launch {
            try {
                gestureRepository.setMainSwitchEnabled(enabled)
                
                if (enabled) {
                    gestureDetector.startDetection()
                } else {
                    gestureDetector.stopDetection()
                }
                
                _uiState.update { 
                    it.copy(
                        isMainSwitchEnabled = enabled,
                        isGestureDetectionActive = gestureDetector.isDetectionEnabled()
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Failed to toggle gesture detection") }
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
                    action = "1" // Back action by default
                )
                gestureRepository.insertGesture(newGesture)
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Failed to add gesture") }
            }
        }
    }

    fun showHelp() {
        // Navigate to help/FAQ
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}