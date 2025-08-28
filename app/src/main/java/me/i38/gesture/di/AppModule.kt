package me.i38.gesture.di

import android.content.Context
import android.content.SharedPreferences
import android.hardware.SensorManager
import android.preference.PreferenceManager
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.i38.gesture.data.database.GestureDatabase
import me.i38.gesture.data.repository.GestureRepository
import me.i38.gesture.data.repository.GestureRepositoryImpl
import me.i38.gesture.utils.PermissionManager
import me.i38.gesture.utils.SensorHelper
import me.i38.gesture.utils.ActionExecutor
import me.i38.gesture.utils.GestureDetector
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun provideSensorManager(@ApplicationContext context: Context): SensorManager {
        return context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    @Provides
    @Singleton
    fun provideGestureDatabase(@ApplicationContext context: Context): GestureDatabase {
        return Room.databaseBuilder(
            context,
            GestureDatabase::class.java,
            "gesture_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideGestureRepository(
        database: GestureDatabase,
        sharedPreferences: SharedPreferences
    ): GestureRepository {
        return GestureRepositoryImpl(database, sharedPreferences)
    }

    @Provides
    @Singleton
    fun providePermissionManager(@ApplicationContext context: Context): PermissionManager {
        return PermissionManager(context)
    }

    @Provides
    @Singleton
    fun provideSensorHelper(
        @ApplicationContext context: Context,
        sensorManager: SensorManager
    ): SensorHelper {
        return SensorHelper(context, sensorManager)
    }

    @Provides
    @Singleton
    fun provideActionExecutor(@ApplicationContext context: Context): ActionExecutor {
        return ActionExecutor(context)
    }

    @Provides
    @Singleton
    fun provideGestureDetector(
        sensorHelper: SensorHelper,
        actionExecutor: ActionExecutor,
        gestureRepository: GestureRepository
    ): GestureDetector {
        return GestureDetector(sensorHelper, actionExecutor, gestureRepository)
    }
}