package com.example.taskdive.data.room.mappers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.taskdive.data.room.entities.TagEntity
import com.example.taskdive.domain.models.Tag

fun TagEntity.toTagModel(): Tag = Tag(tagId, title, color?.let { Color(it) })
fun Tag.toTagEntity(): TagEntity = TagEntity(tagId, title, color?.toArgb())