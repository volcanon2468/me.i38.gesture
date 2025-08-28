package me.i38.gesture.service

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.utils.GestureDetector
import javax.inject.Inject

@AndroidEntryPoint
class GestureAccessibilityService : AccessibilityService() {

    @Inject
    lateinit var gestureDetector: GestureDetector

    companion object {
        var instance: GestureAccessibilityService? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.d("AccessibilityService", "Service created")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d("AccessibilityService", "Service connected")
        
        // Start gesture detection
        gestureDetector.startDetection()
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
        
        // Stop gesture detection
        gestureDetector.stopDetection()
        
        Log.d("AccessibilityService", "Service destroyed")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Handle accessibility events if needed for automation features
        event?.let {
            Log.d("AccessibilityService", "Accessibility event: ${it.eventType}")
        }
    }

    override fun onInterrupt() {
        Log.d("AccessibilityService", "Service interrupted")
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("AccessibilityService", "Service unbound")
        return super.onUnbind(intent)
    }
}