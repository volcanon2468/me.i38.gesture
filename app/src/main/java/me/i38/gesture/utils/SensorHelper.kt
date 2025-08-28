package me.i38.gesture.utils

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import me.i38.gesture.data.model.GestureEvent
import me.i38.gesture.data.model.SensorData
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs
import kotlin.math.sqrt

@Singleton
class SensorHelper @Inject constructor(
    private val context: Context,
    private val sensorManager: SensorManager
) : SensorEventListener {

    private val gyroscope: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    private val accelerometer: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    
    private val gestureChannel = Channel<GestureEvent>(Channel.UNLIMITED)
    val gestureFlow: Flow<GestureEvent> = gestureChannel.receiveAsFlow()
    
    private var isListening = false
    private var lastGestureTime = 0L
    private var gestureThreshold = 2.0f
    private val gestureDebounceTime = 500L // ms
    
    fun startListening() {
        if (!isListening && hasGyroscope()) {
            try {
                gyroscope?.let { 
                    sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME)
                }
                accelerometer?.let {
                    sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME)
                }
                isListening = true
                Log.d("SensorHelper", "Started listening to sensors")
            } catch (e: Exception) {
                Log.e("SensorHelper", "Error starting sensor listening", e)
            }
        }
    }

    fun stopListening() {
        if (isListening) {
            try {
                sensorManager.unregisterListener(this)
                isListening = false
                Log.d("SensorHelper", "Stopped listening to sensors")
            } catch (e: Exception) {
                Log.e("SensorHelper", "Error stopping sensor listening", e)
            }
        }
    }

    fun setGestureThreshold(threshold: Float) {
        gestureThreshold = threshold
    }

    fun hasGyroscope(): Boolean {
        return gyroscope != null
    }

    fun hasAccelerometer(): Boolean {
        return accelerometer != null
    }

    fun isListening(): Boolean {
        return isListening
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let { sensorEvent ->
            try {
                when (sensorEvent.sensor.type) {
                    Sensor.TYPE_GYROSCOPE -> {
                        processGyroscopeData(sensorEvent.values)
                    }
                    Sensor.TYPE_ACCELEROMETER -> {
                        processAccelerometerData(sensorEvent.values)
                    }
                }
            } catch (e: Exception) {
                Log.e("SensorHelper", "Error processing sensor data", e)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d("SensorHelper", "Sensor accuracy changed: ${sensor?.name}, accuracy: $accuracy")
    }

    private fun processGyroscopeData(values: FloatArray) {
        val currentTime = System.currentTimeMillis()
        
        // Debounce gestures
        if (currentTime - lastGestureTime < gestureDebounceTime) {
            return
        }

        val x = values[0] // Rotation around X-axis
        val y = values[1] // Rotation around Y-axis  
        val z = values[2] // Rotation around Z-axis

        // Check for significant rotation on each axis
        when {
            abs(x) > gestureThreshold -> {
                val direction = if (x > 0) 1 else -1
                gestureChannel.trySend(GestureEvent(1, direction, abs(x)))
                lastGestureTime = currentTime
            }
            abs(y) > gestureThreshold -> {
                val direction = if (y > 0) 1 else -1
                gestureChannel.trySend(GestureEvent(2, direction, abs(y)))
                lastGestureTime = currentTime
            }
            abs(z) > gestureThreshold -> {
                val direction = if (z > 0) 1 else -1
                gestureChannel.trySend(GestureEvent(3, direction, abs(z)))
                lastGestureTime = currentTime
            }
        }
    }

    private fun processAccelerometerData(values: FloatArray) {
        // Process accelerometer data for shake detection
        val magnitude = sqrt(values[0] * values[0] + values[1] * values[1] + values[2] * values[2])
        
        // Shake detection
        if (magnitude > 15.0f) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastGestureTime > gestureDebounceTime) {
                gestureChannel.trySend(GestureEvent(4, 1, magnitude)) // Shake gesture
                lastGestureTime = currentTime
            }
        }
    }
}