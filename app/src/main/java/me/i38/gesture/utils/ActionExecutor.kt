package me.i38.gesture.utils

import android.accessibilityservice.AccessibilityService
import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import me.i38.gesture.R
import me.i38.gesture.service.GestureAccessibilityService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActionExecutor @Inject constructor(
    private val context: Context
) {

    private val vibrator: Vibrator by lazy {
        ContextCompat.getSystemService(context, Vibrator::class.java)!!
    }

    private val audioManager: AudioManager by lazy {
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }

    private val notificationManager: NotificationManager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private val cameraManager: CameraManager by lazy {
        context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    private val wifiManager: WifiManager by lazy {
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    fun executeAction(actionId: String, showToast: Boolean = true): Boolean {
        return try {
            val success = when (actionId) {
                "0" -> true // None action
                "1" -> performBack()
                "2" -> performHome()
                "3" -> performRecent()
                "4" -> performNotification()
                "5" -> performQuickSettings()
                "6" -> performLastApp()
                "7" -> performPowerDialog()
                "8" -> performAssistant()
                "9" -> performSplitScreen()
                "A" -> toggleAutoRotation()
                "B" -> toggleRotation()
                "C" -> toggleNotificationPanel()
                "D" -> toggleWifi()
                "E" -> toggleBluetooth()
                "F" -> toggleFlashlight()
                "G" -> performScrollUp()
                "H" -> performScrollDown()
                "I" -> performLeftHandedMode()
                "J" -> toggleRingerMode()
                "K" -> forcePortrait()
                "L" -> toggleNFC()
                "M" -> performRightHandedMode()
                "O" -> showNetworkPanel()
                "P" -> openWechatPay()
                "Q" -> toggleKeepScreenOn()
                "R" -> toggleTouchProtection()
                "S" -> showVolumePanel()
                "U" -> toggleLocation()
                "a" -> toggleMediaPlayPause()
                "b" -> openAlipayQR()
                "c" -> openAlipayPay()
                "d" -> openWechatQR()
                "e" -> takeScreenshot()
                "f" -> showPanel()
                "l" -> lockScreen()
                "m" -> showMousePad()
                "n" -> mediaNext()
                "o" -> volumeUp()
                "p" -> pauseGestures()
                "q" -> volumeDown()
                "r" -> mediaPrevious()
                "s" -> stopGestures()
                "t" -> forceLandscape()
                "u" -> showVolumeAdjustPanel()
                "v" -> setBrightnessAuto()
                "w" -> increaseBrightness()
                "x" -> decreaseBrightness()
                "y" -> changeInputMethod()
                else -> executeCustomAction(actionId)
            }

            if (success && showToast) {
                showActionToast(actionId)
            }

            success
        } catch (e: Exception) {
            Log.e("ActionExecutor", "Error executing action: $actionId", e)
            false
        }
    }

    private fun performBack(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK) ?: false
    }

    private fun performHome(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME) ?: false
    }

    private fun performRecent(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS) ?: false
    }

    private fun performNotification(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS) ?: false
    }

    private fun performQuickSettings(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_QUICK_SETTINGS) ?: false
    }

    private fun performLastApp(): Boolean {
        // Simulate double tap on recent button
        val service = getAccessibilityService()
        return if (service != null) {
            service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS)
            android.os.Handler().postDelayed({
                service.performGlobalAction(AccessibilityService.GLOBAL_ACTION_RECENTS)
            }, 100)
            true
        } else {
            false
        }
    }

    private fun performPowerDialog(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_POWER_DIALOG) ?: false
        } else {
            false
        }
    }

    private fun performAssistant(): Boolean {
        return try {
            val intent = Intent(Intent.ACTION_VOICE_COMMAND).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun performSplitScreen(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) ?: false
        } else {
            false
        }
    }

    private fun toggleAutoRotation(): Boolean {
        return try {
            val currentSetting = Settings.System.getInt(
                context.contentResolver,
                Settings.System.ACCELEROMETER_ROTATION,
                0
            )
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.ACCELEROMETER_ROTATION,
                if (currentSetting == 0) 1 else 0
            )
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleRotation(): Boolean {
        return try {
            val currentRotation = Settings.System.getInt(
                context.contentResolver,
                Settings.System.USER_ROTATION,
                0
            )
            val newRotation = (currentRotation + 1) % 4
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.USER_ROTATION,
                newRotation
            )
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleNotificationPanel(): Boolean {
        return performNotification()
    }

    private fun toggleWifi(): Boolean {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // On Android 10+, open WiFi settings instead
                val intent = Intent(Settings.ACTION_WIFI_SETTINGS).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(intent)
                true
            } else {
                @Suppress("DEPRECATION")
                wifiManager.isWifiEnabled = !wifiManager.isWifiEnabled
                true
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleBluetooth(): Boolean {
        return try {
            val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
            if (bluetoothAdapter != null) {
                if (bluetoothAdapter.isEnabled) {
                    bluetoothAdapter.disable()
                } else {
                    bluetoothAdapter.enable()
                }
                true
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleFlashlight(): Boolean {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val cameraId = cameraManager.cameraIdList[0]
                val isFlashlightOn = getFlashlightState()
                cameraManager.setTorchMode(cameraId, !isFlashlightOn)
                true
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun getFlashlightState(): Boolean {
        // This would need to be tracked in a separate state manager
        return false
    }

    private fun performScrollUp(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GESTURE_SWIPE_UP) ?: false
    }

    private fun performScrollDown(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GESTURE_SWIPE_DOWN) ?: false
    }

    private fun performLeftHandedMode(): Boolean {
        // Implementation depends on device manufacturer
        return false
    }

    private fun performRightHandedMode(): Boolean {
        // Implementation depends on device manufacturer
        return false
    }

    private fun toggleRingerMode(): Boolean {
        return try {
            val currentMode = audioManager.ringerMode
            val newMode = when (currentMode) {
                AudioManager.RINGER_MODE_NORMAL -> AudioManager.RINGER_MODE_VIBRATE
                AudioManager.RINGER_MODE_VIBRATE -> AudioManager.RINGER_MODE_SILENT
                else -> AudioManager.RINGER_MODE_NORMAL
            }
            audioManager.ringerMode = newMode
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun forcePortrait(): Boolean {
        // This would require activity context
        return false
    }

    private fun forceLandscape(): Boolean {
        // This would require activity context
        return false
    }

    private fun toggleNFC(): Boolean {
        return try {
            val intent = Intent(Settings.ACTION_NFC_SETTINGS).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun showNetworkPanel(): Boolean {
        return try {
            val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun openWechatPay(): Boolean {
        return try {
            val intent = context.packageManager.getLaunchIntentForPackage("com.tencent.mm")
            if (intent != null) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
                true
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleKeepScreenOn(): Boolean {
        // This would need to be implemented with overlay window
        return false
    }

    private fun toggleTouchProtection(): Boolean {
        // This would need to be implemented with overlay window
        return false
    }

    private fun showVolumePanel(): Boolean {
        return try {
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleLocation(): Boolean {
        return try {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun toggleMediaPlayPause(): Boolean {
        return getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) ?: false
    }

    private fun openAlipayQR(): Boolean {
        return try {
            val intent = context.packageManager.getLaunchIntentForPackage("com.eg.android.AlipayGphone")
            if (intent != null) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
                true
            } else {
                false
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun openAlipayPay(): Boolean {
        return openAlipayQR()
    }

    private fun openWechatQR(): Boolean {
        return openWechatPay()
    }

    private fun takeScreenshot(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_TAKE_SCREENSHOT) ?: false
        } else {
            false
        }
    }

    private fun showPanel(): Boolean {
        // This would show the custom panel overlay
        return false
    }

    private fun lockScreen(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getAccessibilityService()?.performGlobalAction(AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN) ?: false
        } else {
            false
        }
    }

    private fun showMousePad(): Boolean {
        // This would show the mouse pad overlay
        return false
    }

    private fun mediaNext(): Boolean {
        return try {
            audioManager.dispatchMediaKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_MEDIA_NEXT))
            audioManager.dispatchMediaKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_UP, android.view.KeyEvent.KEYCODE_MEDIA_NEXT))
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun mediaPrevious(): Boolean {
        return try {
            audioManager.dispatchMediaKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS))
            audioManager.dispatchMediaKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_UP, android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS))
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun volumeUp(): Boolean {
        return try {
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun volumeDown(): Boolean {
        return try {
            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun pauseGestures(): Boolean {
        // This would pause gesture detection
        return true
    }

    private fun stopGestures(): Boolean {
        // This would stop gesture detection
        return true
    }

    private fun showVolumeAdjustPanel(): Boolean {
        return showVolumePanel()
    }

    private fun setBrightnessAuto(): Boolean {
        return try {
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
            )
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun increaseBrightness(): Boolean {
        return try {
            val currentBrightness = Settings.System.getInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS,
                128
            )
            val newBrightness = minOf(255, currentBrightness + 25)
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS,
                newBrightness
            )
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun decreaseBrightness(): Boolean {
        return try {
            val currentBrightness = Settings.System.getInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS,
                128
            )
            val newBrightness = maxOf(0, currentBrightness - 25)
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS,
                newBrightness
            )
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun changeInputMethod(): Boolean {
        return try {
            val intent = Intent("android.settings.SHOW_INPUT_METHOD_PICKER").apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun executeCustomAction(actionId: String): Boolean {
        return try {
            when {
                actionId.startsWith("intent:") -> {
                    val intent = Intent.parseUri(actionId, Intent.URI_INTENT_SCHEME)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(intent)
                    true
                }
                actionId.startsWith("shortcut:") -> {
                    val shortcutUri = actionId.substring(9)
                    val intent = Intent.parseUri(shortcutUri, Intent.URI_INTENT_SCHEME)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(intent)
                    true
                }
                actionId.startsWith("view:") -> {
                    val url = actionId.substring(5)
                    val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url)).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                    true
                }
                else -> {
                    // Try to launch as package name
                    val intent = context.packageManager.getLaunchIntentForPackage(actionId)
                    if (intent != null) {
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                        true
                    } else {
                        false
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("ActionExecutor", "Error executing custom action: $actionId", e)
            false
        }
    }

    private fun getAccessibilityService(): AccessibilityService? {
        return GestureAccessibilityService.instance
    }

    private fun showActionToast(actionId: String) {
        val actionName = getActionName(actionId)
        Toast.makeText(context, "Executed: $actionName", Toast.LENGTH_SHORT).show()
    }

    private fun getActionName(actionId: String): String {
        return when (actionId) {
            "0" -> "None"
            "1" -> "Back"
            "2" -> "Home"
            "3" -> "Recent Tasks"
            "4" -> "Notification"
            "5" -> "Quick Settings"
            "6" -> "Last App"
            "7" -> "Power Dialog"
            "8" -> "Voice Assistant"
            "9" -> "Split Screen"
            else -> "Custom Action"
        }
    }

    fun vibrate(intensity: Int) {
        try {
            if (intensity > 0 && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(intensity.toLong(), VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(intensity.toLong())
                }
            }
        } catch (e: Exception) {
            Log.e("ActionExecutor", "Error vibrating", e)
        }
    }
}