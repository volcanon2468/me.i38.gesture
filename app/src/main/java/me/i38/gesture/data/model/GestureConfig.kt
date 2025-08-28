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

@Parcelize
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