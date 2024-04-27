package com.example.taskdive.domain.usecases.list

import com.example.taskdive.data.repository.DiveRepository
import com.example.taskdive.domain.State
import com.example.taskdive.domain.models.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TaskListUseCase(
    private val repository: DiveRepository
) {
    fun getTasks(searchText: String?): Flow<State<List<Task>>> = flow {
        try {
            emit(State.Loading())
            val tasks = repository.getAllTasks()
            if (tasks.isNullOrEmpty()) {
                emit(State.Empty())
            } else {
                emit(State.Success(
                    if (searchText != null)
                        tasks.filter { it.title.contains(searchText, ignoreCase = true) }
                    else tasks)
                )
            }
        } catch (e: Exception) {
            emit(State.Error(e.localizedMessage))
        }
    }
}
