package com.example.taskdive.domain.usecases.list

import com.example.taskdive.data.repository.DiveRepository
import com.example.taskdive.domain.models.Task
import com.example.taskdive.domain.usecases.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TaskListUseCase(
    private val repository: DiveRepository
) {
    fun getAllTasks(): Flow<State<List<Task>>> = flow {
        try {
            emit(State.Loading())

            val tasks = repository.getAllTasks()

            if (tasks.isNullOrEmpty()) {
                emit(State.Empty())
            } else {
                emit(State.Success(tasks))
            }
        } catch (e: Exception) {
            emit(State.Error(e.localizedMessage))
        }
    }
}
