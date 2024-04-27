package com.example.taskdive.data.room.mappers

import com.example.taskdive.data.room.entities.TaskEntity
import com.example.taskdive.domain.models.Task


fun TaskEntity.toTaskModel(): Task {
    return Task(
        taskId,
        title,
        info,
        status,
        startDate,
        finDate,
        repeatEveryDayOfWeek,
        repeatEveryDayOfMonth,
        repeatEveryDayOfYear,
        repeatThrough,
        importance,
        difficulty
    )
}

fun Task.toTaskEntity(): TaskEntity {
    return TaskEntity(

        null,
        title,
        info,
        status,
        startDate,
        finDate,
        repeatEveryDayOfWeek,
        repeatEveryDayOfMonth,
        repeatEveryDayOfYear,
        repeatThrough,
        importance,
        difficulty
    )
}