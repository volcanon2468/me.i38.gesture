package me.i38.gesture.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.R

@AndroidEntryPoint
class GestureExtraService : Service() {

    companion object {
        private const val NOTIFICATION_ID = 1001
        private const val CHANNEL_ID = "gesture_extra_service"
        var instance: GestureExtraService? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        createNotificationChannel()
        Log.d("GestureExtraService", "Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, createNotification())
        Log.d("GestureExtraService", "Service started")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        instance = null
        Log.d("GestureExtraService", "Service destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Gesture Extra Service",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Background service for advanced gesture features"
                setShowBadge(false)
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Micro Gesture")
            .setContentText("Advanced features running")
            .setSmallIcon(R.drawable.ic_gesture)
            .setOngoing(true)
            .setShowWhen(false)
            .build()
    }
}