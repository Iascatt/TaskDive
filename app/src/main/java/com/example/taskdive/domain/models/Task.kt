package com.example.taskdive.domain.models

import java.util.Date

data class Task(
    val taskId: Int,
    // основная информация
    // название задачи
    val title: String,
    // подробная информация о задаче
    val info: String?,
    // статус выполнения
    val status: Status,


    // дополнительная информация, можно не указывать
    // дата и время начала
    val startDate: Date?,
    // дата и время окончания
    val finDate: Date?,
    // если задача единовременная, то startDate остается пустой, а finDate - время выполнения

    // есть 2 варианта повторения задачи:
    // в определенный день года/месяца/недели
    // или через промежуток времени
    val repeatEveryDayOfWeek: Weekday?,
    val repeatEveryDayOfMonth: Int?, //от 1 до 31
    val repeatEveryDayOfYear: Int?, // от 1 до 366
    val repeatThrough: Date?,

    // Параметры задачи для определения порядка
    // от 1 до 5
    val importance: Int?,
    val difficulty: Int?
)