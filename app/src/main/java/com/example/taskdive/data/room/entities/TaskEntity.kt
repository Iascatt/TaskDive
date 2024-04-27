package com.example.taskdive.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskdive.domain.models.Status
import com.example.taskdive.domain.models.Weekday
import java.util.Date

@Entity
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int?,
    // основная информация
    @ColumnInfo(name = "title", defaultValue = "") val title: String,
    @ColumnInfo(name = "info") val info: String?,
    @ColumnInfo(name = "status") val status: Status,


    // дополнительная информация, можно не указывать
    @ColumnInfo(name = "start_date") val startDate: Date?,
    @ColumnInfo(name = "fin_date") val finDate: Date?,

    @ColumnInfo(name = "repeat_every_day_of_week") val repeatEveryDayOfWeek: Weekday?, //от 1 до 7
    @ColumnInfo(name = "repeat_every_day_of_month") val repeatEveryDayOfMonth: Int?, //от 1 до 31
    @ColumnInfo(name = "repeat_every_day_of_year") val repeatEveryDayOfYear: Int?, // от 1 до 366
    @ColumnInfo(name = "repeat_through") val repeatThrough: Date?,

    // параметры
    // от 1 до 5
    @ColumnInfo(name = "importance") val importance: Int?,
    @ColumnInfo(name = "difficulty") val difficulty: Int?
)