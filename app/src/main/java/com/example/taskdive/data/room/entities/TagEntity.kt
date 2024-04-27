package com.example.taskdive.data.room.entities

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskdive.domain.models.Tag

@Entity
data class TagEntity(
    @PrimaryKey(autoGenerate = true) val tagId: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "color") val color: Int?
)