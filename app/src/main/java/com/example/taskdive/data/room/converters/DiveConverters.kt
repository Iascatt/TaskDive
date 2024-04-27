package com.example.taskdive.data.room.converters

import androidx.room.TypeConverter
import java.util.Date

class DiveConverters {
    @TypeConverter
    fun fromDate(date: Date?) = date?.time

    @TypeConverter
    fun toDate(millis: Long?) = millis?.let { Date(it) }

}
