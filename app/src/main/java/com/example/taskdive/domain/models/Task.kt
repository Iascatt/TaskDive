package com.example.taskdive.domain.models

import java.util.Date

data class Task(
    val taskId: Int? = null,
    // основная информация
    // название задачи
    val title: String,
    // подробная информация о задаче
    val info: String?,
    // статус выполнения
    val status: Status = Status.TO_DO,


    // дополнительная информация, можно не указывать
    // дата и время начала
    val startDate: Date? = null,
    // дата и время окончания
    val finDate: Date? = null,
    // если задача единовременная, то startDate остается пустой, а finDate - время выполнения

    // есть 2 варианта повторения задачи:
    // в определенный день года/месяца/недели
    // или через промежуток времени
    val repeatEveryDayOfWeek: Weekday? = null,
    val repeatEveryDayOfMonth: Int? = null, //от 1 до 31
    val repeatEveryDayOfYear: Int? = null, // от 1 до 366
    val repeatThrough: Date? = null,

    // Параметры задачи для определения порядка
    // от 1 до 5
    val importance: Int? = null,
    val difficulty: Int? = null
)