package me.i38.gesture.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.utils.ActionExecutor
import javax.inject.Inject

@AndroidEntryPoint
class BeautifySwitchService : Service() {

    @Inject
    lateinit var actionExecutor: ActionExecutor

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.getStringExtra("action")
        
        if (!action.isNullOrEmpty()) {
            Log.d("BeautifySwitchService", "Executing switch action: $action")
            actionExecutor.executeAction(action, showToast = false)
        }
        
        return START_NOT_STICKY
    }
}