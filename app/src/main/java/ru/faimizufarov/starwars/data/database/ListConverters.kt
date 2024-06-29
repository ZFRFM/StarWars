package ru.faimizufarov.starwars.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListConverters {
    @TypeConverter
    fun fromListToString(stringList: List<String>): String {
        return Json.encodeToString(stringList)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<String> {
        return Json.decodeFromString(string)
    }
}