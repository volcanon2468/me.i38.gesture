package me.i38.gesture.data.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import me.i38.gesture.data.database.GestureDatabase
import me.i38.gesture.data.model.AppConfig
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.model.RobotConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GestureRepositoryImpl @Inject constructor(
    private val database: GestureDatabase,
    private val sharedPreferences: SharedPreferences
) : GestureRepository {

    private val gson = Gson()

    // Gesture operations
    override fun getGesturesForApp(appPackage: String): Flow<List<GestureConfig>> {
        return database.gestureDao().getGesturesForApp(appPackage)
    }

    override fun getAllGestures(): Flow<List<GestureConfig>> {
        return database.gestureDao().getAllGestures()
    }

    override fun getEnabledGestures(): Flow<List<GestureConfig>> {
        return database.gestureDao().getEnabledGestures()
    }

    override suspend fun getGestureById(id: Long): GestureConfig? {
        return database.gestureDao().getGestureById(id)
    }

    override suspend fun insertGesture(gesture: GestureConfig): Long {
        return database.gestureDao().insertGesture(gesture)
    }

    override suspend fun updateGesture(gesture: GestureConfig) {
        database.gestureDao().updateGesture(gesture.copy(updatedAt = System.currentTimeMillis()))
    }

    override suspend fun deleteGesture(gesture: GestureConfig) {
        database.gestureDao().deleteGesture(gesture)
    }

    override suspend fun deleteGesturesForApp(appPackage: String) {
        database.gestureDao().deleteGesturesForApp(appPackage)
    }

    // Robot operations
    override fun getEnabledRobots(): Flow<List<RobotConfig>> {
        return database.robotDao().getEnabledRobots()
    }

    override fun getAllRobots(): Flow<List<RobotConfig>> {
        return database.robotDao().getAllRobots()
    }

    override suspend fun getRobotById(id: Long): RobotConfig? {
        return database.robotDao().getRobotById(id)
    }

    override suspend fun insertRobot(robot: RobotConfig): Long {
        return database.robotDao().insertRobot(robot)
    }

    override suspend fun updateRobot(robot: RobotConfig) {
        database.robotDao().updateRobot(robot)
    }

    override suspend fun deleteRobot(robot: RobotConfig) {
        database.robotDao().deleteRobot(robot)
    }

    override suspend fun setRobotEnabled(id: Long, enabled: Boolean) {
        database.robotDao().setRobotEnabled(id, enabled)
    }

    // App configurations
    override suspend fun getConfiguredApps(): List<String> {
        return database.gestureDao().getConfiguredApps()
    }

    override suspend fun getAppConfig(packageName: String): AppConfig? {
        return try {
            val gesturesList = mutableListOf<GestureConfig>()
            getGesturesForApp(packageName).collect { gesturesList.addAll(it) }
            val panelActions = getPanelActions(packageName)
            
            AppConfig(
                packageName = packageName,
                appName = packageName,
                isCustomEnabled = gesturesList.isNotEmpty(),
                gestures = gesturesList,
                panelActions = panelActions
            )
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun saveAppConfig(appConfig: AppConfig) {
        try {
            // Delete existing gestures for this app
            deleteGesturesForApp(appConfig.packageName)
            
            // Insert new gestures
            appConfig.gestures.forEach { gesture ->
                insertGesture(gesture.copy(appPackage = appConfig.packageName))
            }
            
            // Save panel actions
            savePanelActions(appConfig.packageName, appConfig.panelActions)
        } catch (e: Exception) {
            // Handle error
        }
    }

    // Settings
    override fun isMainSwitchEnabled(): Boolean {
        return sharedPreferences.getBoolean("main_switch", false)
    }

    override fun setMainSwitchEnabled(enabled: Boolean) {
        sharedPreferences.edit().putBoolean("main_switch", enabled).apply()
    }

    override fun getVibrateIntensity(): Int {
        return sharedPreferences.getInt("vibrate_intensity", 10)
    }

    override fun setVibrateIntensity(intensity: Int) {
        sharedPreferences.edit().putInt("vibrate_intensity", intensity).apply()
    }

    override fun isToastFeedbackEnabled(): Boolean {
        return sharedPreferences.getBoolean("toast_feedback", true)
    }

    override fun setToastFeedbackEnabled(enabled: Boolean) {
        sharedPreferences.edit().putBoolean("toast_feedback", enabled).apply()
    }

    // Panel actions
    override fun getPanelActions(appPackage: String): List<String> {
        val json = sharedPreferences.getString("panel_$appPackage", "[]") ?: "[]"
        return try {
            gson.fromJson(json, object : TypeToken<List<String>>() {}.type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun savePanelActions(appPackage: String, actions: List<String>) {
        val json = gson.toJson(actions)
        sharedPreferences.edit().putString("panel_$appPackage", json).apply()
    }

    // Export/Import
    override suspend fun exportConfiguration(): String {
        return try {
            val allGestures = mutableListOf<GestureConfig>()
            getAllGestures().collect { allGestures.addAll(it) }
            
            val allRobots = mutableListOf<RobotConfig>()
            getAllRobots().collect { allRobots.addAll(it) }
            
            val config = mapOf(
                "gestures" to allGestures,
                "robots" to allRobots,
                "settings" to mapOf(
                    "main_switch" to isMainSwitchEnabled(),
                    "vibrate_intensity" to getVibrateIntensity(),
                    "toast_feedback" to isToastFeedbackEnabled()
                ),
                "version" to "5.7.7P",
                "exported_at" to System.currentTimeMillis()
            )
            
            gson.toJson(config)
        } catch (e: Exception) {
            "{}"
        }
    }

    override suspend fun importConfiguration(config: String): Boolean {
        return try {
            val configMap: Map<String, Any> = gson.fromJson(config, object : TypeToken<Map<String, Any>>() {}.type)
            
            // Import gestures
            val gesturesJson = gson.toJson(configMap["gestures"])
            val gestures: List<GestureConfig> = gson.fromJson(gesturesJson, object : TypeToken<List<GestureConfig>>() {}.type) ?: emptyList()
            gestures.forEach { insertGesture(it) }
            
            // Import robots
            val robotsJson = gson.toJson(configMap["robots"])
            val robots: List<RobotConfig> = gson.fromJson(robotsJson, object : TypeToken<List<RobotConfig>>() {}.type) ?: emptyList()
            robots.forEach { insertRobot(it) }
            
            // Import settings
            val settings = configMap["settings"] as? Map<String, Any>
            settings?.let {
                setMainSwitchEnabled(it["main_switch"] as? Boolean ?: false)
                setVibrateIntensity((it["vibrate_intensity"] as? Double)?.toInt() ?: 10)
                setToastFeedbackEnabled(it["toast_feedback"] as? Boolean ?: true)
            }
            
            true
        } catch (e: Exception) {
            false
        }
    }
}