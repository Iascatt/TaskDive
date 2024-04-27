package com.example.taskdive.data.room.entities

import androidx.room.Entity

@Entity(primaryKeys = ["taskId", "tagId"])
data class TaskTagCrossRef(
    val taskId: Int,
    val tagId: Int,
)
