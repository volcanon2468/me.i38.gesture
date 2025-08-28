package me.i38.gesture.utils

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.model.GestureEvent
import me.i38.gesture.data.repository.GestureRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs

@Singleton
class GestureDetector @Inject constructor(
    private val sensorHelper: SensorHelper,
    private val actionExecutor: ActionExecutor,
    private val gestureRepository: GestureRepository
) {
    
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private var isEnabled = false
    private var enabledGestures = listOf<GestureConfig>()
    private var lastGestureTime = 0L
    private val gestureDebounceTime = 1000L // 1 second between gestures

    fun startDetection() {
        if (!isEnabled) {
            isEnabled = true
            sensorHelper.startListening()
            
            // Collect gesture events
            scope.launch {
                sensorHelper.gestureFlow.collect { gestureEvent ->
                    processGestureEvent(gestureEvent)
                }
            }
            
            // Collect enabled gestures
            scope.launch {
                gestureRepository.getEnabledGestures().collect { gestures ->
                    enabledGestures = gestures
                    Log.d("GestureDetector", "Updated enabled gestures: ${gestures.size}")
                }
            }
            
            Log.d("GestureDetector", "Gesture detection started")
        }
    }

    fun stopDetection() {
        if (isEnabled) {
            isEnabled = false
            sensorHelper.stopListening()
            Log.d("GestureDetector", "Gesture detection stopped")
        }
    }

    fun isDetectionEnabled(): Boolean {
        return isEnabled
    }

    private fun processGestureEvent(gestureEvent: GestureEvent) {
        if (!isEnabled) return
        
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastGestureTime < gestureDebounceTime) {
            return
        }

        // Find matching gesture configuration
        val matchingGesture = findMatchingGesture(gestureEvent)
        if (matchingGesture != null) {
            Log.d("GestureDetector", "Gesture matched: ${matchingGesture.action}")
            
            // Execute the action
            val success = actionExecutor.executeAction(matchingGesture.action)
            
            if (success) {
                // Provide haptic feedback
                val vibrateIntensity = gestureRepository.getVibrateIntensity()
                if (vibrateIntensity > 0) {
                    actionExecutor.vibrate(vibrateIntensity * 10)
                }
                
                lastGestureTime = currentTime
            }
        }
    }

    private fun findMatchingGesture(gestureEvent: GestureEvent): GestureConfig? {
        return enabledGestures.find { gesture ->
            // Check axis match
            if (gesture.axis != gestureEvent.axis) return@find false
            
            // Check direction match (0 = any direction)
            if (gesture.direction != 0 && gesture.direction != gestureEvent.direction) return@find false
            
            // Check intensity threshold
            val threshold = gesture.threshold.toFloat() / 10.0f // Convert to sensor scale
            if (gestureEvent.intensity < threshold) return@find false
            
            true
        }
    }

    fun updateGestureThreshold(threshold: Float) {
        sensorHelper.setGestureThreshold(threshold)
    }
}