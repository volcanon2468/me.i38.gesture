package me.i38.gesture.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.i38.gesture.data.model.GestureConfig

@Dao
interface GestureDao {
    @Query("SELECT * FROM gesture_configs WHERE appPackage = :appPackage ORDER BY createdAt ASC")
    fun getGesturesForApp(appPackage: String): Flow<List<GestureConfig>>

    @Query("SELECT * FROM gesture_configs ORDER BY appPackage, createdAt ASC")
    fun getAllGestures(): Flow<List<GestureConfig>>

    @Query("SELECT * FROM gesture_configs WHERE id = :id")
    suspend fun getGestureById(id: Long): GestureConfig?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGesture(gesture: GestureConfig): Long

    @Update
    suspend fun updateGesture(gesture: GestureConfig)

    @Delete
    suspend fun deleteGesture(gesture: GestureConfig)

    @Query("DELETE FROM gesture_configs WHERE appPackage = :appPackage")
    suspend fun deleteGesturesForApp(appPackage: String)

    @Query("SELECT DISTINCT appPackage FROM gesture_configs")
    suspend fun getConfiguredApps(): List<String>

    @Query("SELECT * FROM gesture_configs WHERE isEnabled = 1")
    fun getEnabledGestures(): Flow<List<GestureConfig>>
}