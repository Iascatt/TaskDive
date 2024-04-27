package com.example.taskdive.data.room.entities

import androidx.room.Entity

@Entity(primaryKeys = ["supertaskId", "subtaskId"])
data class SupertaskSubtaskCrossRef(
    val supertaskId: Int,
    val subtaskId: Int,
)
