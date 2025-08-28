package me.i38.gesture.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import me.i38.gesture.data.model.GestureConfig
import me.i38.gesture.data.model.RobotConfig

@Database(
    entities = [GestureConfig::class, RobotConfig::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GestureDatabase : RoomDatabase() {
    abstract fun gestureDao(): GestureDao
    abstract fun robotDao(): RobotDao

    companion object {
        @Volatile
        private var INSTANCE: GestureDatabase? = null

        fun getDatabase(context: Context): GestureDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GestureDatabase::class.java,
                    "gesture_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}