package me.i38.gesture.service

import android.annotation.TargetApi
import android.os.Build
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import me.i38.gesture.data.repository.GestureRepository
import me.i38.gesture.utils.GestureDetector
import javax.inject.Inject

@TargetApi(Build.VERSION_CODES.N)
@AndroidEntryPoint
class QuickSettingsTileService : TileService() {

    @Inject
    lateinit var gestureRepository: GestureRepository

    @Inject
    lateinit var gestureDetector: GestureDetector

    override fun onStartListening() {
        super.onStartListening()
        updateTileState()
    }

    override fun onClick() {
        super.onClick()
        
        val isEnabled = gestureRepository.isMainSwitchEnabled()
        val newState = !isEnabled
        
        gestureRepository.setMainSwitchEnabled(newState)
        
        if (newState) {
            gestureDetector.startDetection()
        } else {
            gestureDetector.stopDetection()
        }
        
        updateTileState()
        
        Log.d("QuickTile", "Gesture detection toggled: $newState")
    }

    private fun updateTileState() {
        val tile = qsTile ?: return
        val isEnabled = gestureRepository.isMainSwitchEnabled()
        
        tile.state = if (isEnabled) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        tile.label = "Micro Gesture"
        tile.contentDescription = if (isEnabled) "Gestures enabled" else "Gestures disabled"
        tile.updateTile()
    }
}