package me.i38.gesture.data.repository

import kotlinx.coroutines.flow.Flow
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.model.RobotConfig
import me.i38.gesture.data.model.AppConfig

interface GestureRepository {
    // Gesture operations
    fun getGesturesForApp(appPackage: String): Flow<List<GestureConfig>>
    fun getAllGestures(): Flow<List<GestureConfig>>
    fun getEnabledGestures(): Flow<List<GestureConfig>>
    suspend fun getGestureById(id: Long): GestureConfig?
    suspend fun insertGesture(gesture: GestureConfig): Long
    suspend fun updateGesture(gesture: GestureConfig)
    suspend fun deleteGesture(gesture: GestureConfig)
    suspend fun deleteGesturesForApp(appPackage: String)
    
    // Robot operations
    fun getEnabledRobots(): Flow<List<RobotConfig>>
    fun getAllRobots(): Flow<List<RobotConfig>>
    suspend fun getRobotById(id: Long): RobotConfig?
    suspend fun insertRobot(robot: RobotConfig): Long
    suspend fun updateRobot(robot: RobotConfig)
    suspend fun deleteRobot(robot: RobotConfig)
    suspend fun setRobotEnabled(id: Long, enabled: Boolean)
    
    // App configurations
    suspend fun getConfiguredApps(): List<String>
    suspend fun getAppConfig(packageName: String): AppConfig?
    suspend fun saveAppConfig(appConfig: AppConfig)
    
    // Settings
    fun isMainSwitchEnabled(): Boolean
    fun setMainSwitchEnabled(enabled: Boolean)
    fun getVibrateIntensity(): Int
    fun setVibrateIntensity(intensity: Int)
    fun isToastFeedbackEnabled(): Boolean
    fun setToastFeedbackEnabled(enabled: Boolean)
    
    // Panel actions
    fun getPanelActions(appPackage: String): List<String>
    fun savePanelActions(appPackage: String, actions: List<String>)
    
    // Export/Import
    suspend fun exportConfiguration(): String
    suspend fun importConfiguration(config: String): Boolean
}