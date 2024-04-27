package com.example.taskdive.ui.screens.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdive.domain.models.Task
import com.example.taskdive.domain.State
import com.example.taskdive.domain.usecases.list.TaskListUseCase
import com.example.taskdive.ui.screens.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class CurrentTasksViewModel(
    private val listUseCase: TaskListUseCase
) : ViewModel() {
    private var _tasks = MutableStateFlow(emptyList<Task>())
    var tasks: StateFlow<List<Task>> = _tasks

    private val _tasksState: MutableStateFlow<UiState>  = MutableStateFlow(UiState.Loading)
    val tasksState = _tasksState.asStateFlow()

    private val _tasksMessage: MutableStateFlow<String?>  = MutableStateFlow(null)
    val tasksMessage = _tasksMessage.asStateFlow()

    fun getAllTasks(searchText: String? = null) {
        viewModelScope.launch {
            listUseCase.getTasks(searchText)
                .collect {
                    when (it) {
                        is State.Error -> {
                            _tasksState.value = UiState.Error
                            _tasksMessage.value = it.message
                        }

                        is State.Loading -> _tasksState.value = UiState.Loading

                        is State.Success -> {
                            _tasks.value = it.data ?: listOf()
                            _tasksState.value = UiState.Success
                        }

                        is State.Empty -> {
                            _tasks.value = listOf()
                            _tasksState.value = UiState.Empty
                        }
                    }
                }
        }
    }

}