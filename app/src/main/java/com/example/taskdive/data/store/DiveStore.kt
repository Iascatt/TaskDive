package com.example.taskdive.data.store

import com.example.taskdive.domain.models.Tag
import com.example.taskdive.domain.models.Task

interface DiveStore {
    suspend fun getAllTags(): List<Tag>?

    suspend fun addTag(tag: Tag)

    suspend fun updateTag(tag: Tag)

    suspend fun deleteTag(tag: Tag)

    suspend fun deleteAllTags()

    suspend fun addTask(task: Task)

    suspend fun getAllTasks(): List<Task>?

    suspend fun deleteTask(task: Task)

    suspend fun updateTask(task: Task)

    suspend fun deleteAllTasks()
}
