package me.i38.gesture.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.i38.gesture.data.model.RobotConfig

@Dao
interface RobotDao {
    @Query("SELECT * FROM RobotConfig WHERE isEnabled = 1 ORDER BY createdAt ASC")
    fun getEnabledRobots(): Flow<List<RobotConfig>>

    @Query("SELECT * FROM RobotConfig ORDER BY createdAt ASC")
    fun getAllRobots(): Flow<List<RobotConfig>>

    @Query("SELECT * FROM RobotConfig WHERE id = :id")
    suspend fun getRobotById(id: Long): RobotConfig?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRobot(robot: RobotConfig): Long

    @Update
    suspend fun updateRobot(robot: RobotConfig)

    @Delete
    suspend fun deleteRobot(robot: RobotConfig)

    @Query("UPDATE RobotConfig SET isEnabled = :enabled WHERE id = :id")
    suspend fun setRobotEnabled(id: Long, enabled: Boolean)
}