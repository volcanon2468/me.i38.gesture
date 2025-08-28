package me.i38.gesture

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.SharedPreferences
import android.hardware.SensorManager
import android.os.Build
import android.preference.PreferenceManager
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import me.i38.gesture.data.repository.GestureRepository
import me.i38.gesture.utils.PermissionManager
import me.i38.gesture.utils.SensorHelper
import javax.inject.Inject

@HiltAndroidApp
class GestureApplication : Application() {

    @Inject
    lateinit var gestureRepository: GestureRepository
    
    @Inject
    lateinit var permissionManager: PermissionManager
    
    @Inject
    lateinit var sensorHelper: SensorHelper

    companion object {
        private var instance: GestureApplication? = null
        
        fun getInstance(): GestureApplication {
            return instance ?: throw IllegalStateException("Application not initialized")
        }
        
        fun getContext(): Context = getInstance()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        
        Log.d("GestureApp", "Application starting...")
        
        // Initialize preferences with default values
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
        
        // Create notification channels
        createNotificationChannels()
        
        // Initialize default gestures if first run
        initializeDefaultGestures()
        
        Log.d("GestureApp", "Application initialized successfully")
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            
            // General channel
            val generalChannel = NotificationChannel(
                "general",
                getString(R.string.app_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(generalChannel)
            
            // User channels
            for (i in 1..4) {
                val userChannel = NotificationChannel(
                    "user$i",
                    "${getString(R.string.user_channel)} $i",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                notificationManager.createNotificationChannel(userChannel)
            }
        }
    }

    private fun initializeDefaultGestures() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        if (prefs.getString("gestures_config", "").isEmpty()) {
            val defaultConfig = """
                {
                    "default": {
                        "gestures": [
                            {
                                "axis": "1",
                                "action": "4",
                                "dir": "1",
                                "count": "1",
                                "thresh": "10"
                            },
                            {
                                "axis": "2", 
                                "action": "1",
                                "dir": "1",
                                "count": "1",
                                "thresh": "10"
                            },
                            {
                                "axis": "3",
                                "action": "3", 
                                "dir": "1",
                                "count": "1",
                                "thresh": "10"
                            }
                        ]
                    }
                }
            """.trimIndent()
            
            prefs.edit()
                .putString("gestures_config", defaultConfig)
                .putLong("install_ts", System.currentTimeMillis())
                .apply()
        }
    }
}