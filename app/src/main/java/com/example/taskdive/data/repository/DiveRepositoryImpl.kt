package com.example.taskdive.data.repository

import com.example.taskdive.data.store.DiveStore
import com.example.taskdive.domain.models.Tag
import com.example.taskdive.domain.models.Task

class DiveRepositoryImpl(
    private val diveStore: DiveStore
) : DiveRepository {
    override suspend fun getAllTags(): List<Tag>? {
        return diveStore.getAllTags()
    }

    override suspend fun addTag(tag: Tag) {
        diveStore.addTag(tag)
    }

    override suspend fun updateTag(tag: Tag) {
        diveStore.updateTag(tag)
    }

    override suspend fun deleteTag(tag: Tag) {
        diveStore.deleteTag(tag)
    }

    override suspend fun deleteAllTags() {
        diveStore.deleteAllTags()
    }

    override suspend fun addTask(task: Task) {
        diveStore.addTask(task)
    }

    override suspend fun getAllTasks(): List<Task>? {
        return diveStore.getAllTasks()
    }

    override suspend fun deleteTask(task: Task) {
        diveStore.deleteTask(task)
    }


    override suspend fun updateTask(task: Task) {
        diveStore.updateTask(task)
    }

    override suspend fun deleteAllTasks() {
        diveStore.deleteAllTasks()
    }
}