package com.example.taskdive.data.store

import com.example.taskdive.data.room.database.DiveDatabase
import com.example.taskdive.data.room.mappers.toTagEntity
import com.example.taskdive.data.room.mappers.toTagModel
import com.example.taskdive.data.room.mappers.toTaskEntity
import com.example.taskdive.data.room.mappers.toTaskModel
import com.example.taskdive.domain.models.Tag
import com.example.taskdive.domain.models.Task

class DiveStoreImpl(
    database: DiveDatabase
) : DiveStore {
    private val tags = database.tags
    private val tasks = database.tasks
    override suspend fun getAllTags(): List<Tag> {
        return tags.getAllTags().map { it.toTagModel() }
    }

    override suspend fun addTag(tag: Tag) {
        tags.addTag(tag.toTagEntity())
    }

    override suspend fun updateTag(tag: Tag) {
        tags.updateTag(tag.toTagEntity())
    }

    override suspend fun deleteTag(tag: Tag) {
        tags.deleteTag(tag.toTagEntity())
    }

    override suspend fun deleteAllTags() {
        tags.deleteAllTags()
    }

    override suspend fun addTask(task: Task) {
        tasks.addTask(task.toTaskEntity())
    }

    override suspend fun getAllTasks(): List<Task> {
        return tasks.getAllTasks().map { it.toTaskModel() }
    }

    override suspend fun deleteTask(task: Task) {
        tasks.deleteTask(task.toTaskEntity())
    }

    override suspend fun updateTask(task: Task) {
        tasks.updateTask(task.toTaskEntity())
    }

    override suspend fun deleteAllTasks() {
        tasks.deleteAllTasks()
    }
}
