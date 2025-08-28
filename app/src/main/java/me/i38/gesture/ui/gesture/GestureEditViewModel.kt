package me.i38.gesture.ui.gesture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.repository.GestureRepository
import javax.inject.Inject

@HiltViewModel
class GestureEditViewModel @Inject constructor(
    private val gestureRepository: GestureRepository
) : ViewModel() {

    data class GestureEditUiState(
        val isEditing: Boolean = false,
        val gestureId: Long = -1L,
        val selectedAxis: Int = 1,
        val selectedDirection: Int = 0,
        val threshold: Int = 10,
        val selectedAction: String = "1",
        val count: Int = 1,
        val keyCode: Int = 24,
        val isEnabled: Boolean = true,
        val isLoading: Boolean = false,
        val errorMessage: String? = null
    )

    private val _uiState = MutableStateFlow(GestureEditUiState())
    val uiState: StateFlow<GestureEditUiState> = _uiState.asStateFlow()

    fun loadGesture(gestureId: Long) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                
                val gesture = gestureRepository.getGestureById(gestureId)
                if (gesture != null) {
                    _uiState.update { currentState ->
                        currentState.copy(
                            isEditing = true,
                            gestureId = gesture.id,
                            selectedAxis = gesture.axis,
                            selectedDirection = gesture.direction,
                            threshold = gesture.threshold,
                            selectedAction = gesture.action,
                            count = gesture.count,
                            keyCode = gesture.keyCode,
                            isEnabled = gesture.isEnabled,
                            isLoading = false
                        )
                    }
                } else {
                    _uiState.update { it.copy(isLoading = false, errorMessage = "Gesture not found") }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, errorMessage = "Failed to load gesture") }
            }
        }
    }

    fun setAxis(axis: Int) {
        _uiState.update { it.copy(selectedAxis = axis) }
    }

    fun setDirection(direction: Int) {
        _uiState.update { it.copy(selectedDirection = direction) }
    }

    fun setThreshold(threshold: Int) {
        _uiState.update { it.copy(threshold = threshold) }
    }

    fun setAction(action: String) {
        _uiState.update { it.copy(selectedAction = action) }
    }

    fun setCount(count: Int) {
        _uiState.update { it.copy(count = count) }
    }

    fun setKeyCode(keyCode: Int) {
        _uiState.update { it.copy(keyCode = keyCode) }
    }

    fun setEnabled(enabled: Boolean) {
        _uiState.update { it.copy(isEnabled = enabled) }
    }

    fun saveGesture() {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                
                val currentState = _uiState.value
                val gesture = if (currentState.isEditing) {
                    // Update existing gesture
                    val existingGesture = gestureRepository.getGestureById(currentState.gestureId)
                    existingGesture?.copy(
                        axis = currentState.selectedAxis,
                        direction = currentState.selectedDirection,
                        threshold = currentState.threshold,
                        action = currentState.selectedAction,
                        count = currentState.count,
                        keyCode = currentState.keyCode,
                        isEnabled = currentState.isEnabled
                    )
                } else {
                    // Create new gesture
                    GestureConfig(
                        axis = currentState.selectedAxis,
                        direction = currentState.selectedDirection,
                        threshold = currentState.threshold,
                        action = currentState.selectedAction,
                        count = currentState.count,
                        keyCode = currentState.keyCode,
                        isEnabled = currentState.isEnabled
                    )
                }

                if (gesture != null) {
                    if (currentState.isEditing) {
                        gestureRepository.updateGesture(gesture)
                    } else {
                        gestureRepository.insertGesture(gesture)
                    }
                }
                
                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, errorMessage = "Failed to save gesture") }
            }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}