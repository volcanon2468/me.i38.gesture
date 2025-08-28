package me.i38.gesture.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return try {
            gson.fromJson(value, object : TypeToken<List<String>>() {}.type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    @TypeConverter
    fun fromStringMap(value: Map<String, String>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringMap(value: String): Map<String, String> {
        return try {
            gson.fromJson(value, object : TypeToken<Map<String, String>>() {}.type) ?: emptyMap()
        } catch (e: Exception) {
            emptyMap()
        }
    }
}