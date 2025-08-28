package me.i38.gesture.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "gesture_configs")
data class GestureConfig(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val appPackage: String = "default",
    val axis: Int = 1, // 1=X, 2=Y, 3=Z, 4=Key
    val direction: Int = 0, // 0=Any, 1=Positive, -1=Negative
    val count: Int = 1, // 1=Single, 2=Double
    val threshold: Int = 10,
    val action: String = "0",
    val keyCode: Int = 24, // Volume up by default
    val isEnabled: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) : Parcelable

@Parcelize
@Entity(tableName = "robot_configs")
data class RobotConfig(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val packageName: String,
    val triggerType: String = "ui", // ui, notification
    val nodeText: String = "",
    val className: String = "",
    val filter: String = "",
    val action: String = "click",
    val interval: Long = 1000,
    val memo: String = "",
    val isEnabled: Boolean = true,
    val executionPolicy: String = "once", // once, later, now
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable

@Parcelize
data class ActionConfig(
    val id: String,
    val name: String,
    val description: String = "",
    val iconRes: Int = 0,
    val requiresPermission: String? = null,
    val requiresPlusService: Boolean = false
) : Parcelable

@Parcelize
data class AppConfig(
    val packageName: String,
    val appName: String,
    val isCustomEnabled: Boolean = false,
    val gestures: List<GestureConfig> = emptyList(),
    val panelActions: List<String> = emptyList()
) : Parcelable

data class SensorData(
    val x: Float,
    val y: Float,
    val z: Float,
    val timestamp: Long = System.currentTimeMillis()
)

data class GestureEvent(
    val axis: Int,
    val direction: Int,
    val intensity: Float,
    val timestamp: Long = System.currentTimeMillis()
)

enum class GestureAxis(val value: Int, val displayName: String) {
    X_AXIS(1, "X Axis (Tilt up/down)"),
    Y_AXIS(2, "Y Axis (Tilt left/right)"),
    Z_AXIS(3, "Z Axis (Rotate flat)"),
    KEY_AXIS(4, "Physical Keys")
}

enum class ActionType(val id: String, val displayName: String, val iconRes: Int) {
    NONE("0", "None", R.drawable.ic_none),
    BACK("1", "Back", R.drawable.ic_back),
    HOME("2", "Home", R.drawable.ic_home),
    RECENT("3", "Recent Tasks", R.drawable.ic_recents),
    NOTIFICATION("4", "Notification", R.drawable.ic_notification),
    QUICK_SETTINGS("5", "Quick Settings", R.drawable.ic_quick_settings),
    LAST_APP("6", "Last App", R.drawable.ic_last_app),
    POWER("7", "Power Menu", R.drawable.ic_power),
    ASSISTANT("8", "Voice Assistant", R.drawable.ic_assistant),
    SPLIT_SCREEN("9", "Split Screen", R.drawable.ic_split)
}