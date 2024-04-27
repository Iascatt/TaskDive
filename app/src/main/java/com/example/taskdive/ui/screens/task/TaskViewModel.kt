package com.example.taskdive.ui.screens.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskdive.domain.State
import com.example.taskdive.domain.models.Status
import com.example.taskdive.domain.models.Task
import com.example.taskdive.domain.models.Weekday
import com.example.taskdive.domain.usecases.create.CreateTaskUseCase
import com.example.taskdive.ui.screens.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date

class TaskViewModel(
    private val createUseCase: CreateTaskUseCase
) : ViewModel() {

    private val _taskState: MutableStateFlow<UiState> = MutableStateFlow(UiState.NotLoading)
    val taskState = _taskState.asStateFlow()

    private val _taskMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    val taskMessage = _taskMessage.asStateFlow()

    private val _editable: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val editable = _editable.asStateFlow()

    private val _task: MutableStateFlow<Task?> = MutableStateFlow(null)
    val task = _task.asStateFlow()

    fun createTask(
        title: String?,
        info: String?,
        startDate: Date?,
        finDate: Date?,
        repeatEveryDayOfWeek: Weekday? = null,
        repeatEveryDayOfMonth: Int? = null, //от 1 до 31
        repeatEveryDayOfYear: Int? = null, // от 1 до 366
        repeatThrough: Date? = null,
        importance: Int? = null,
        difficulty: Int? = null
    ) {
        viewModelScope.launch {
            createUseCase.createTask(
                title,
                info,
                startDate,
                finDate,
                repeatEveryDayOfWeek,
                repeatEveryDayOfMonth,
                repeatEveryDayOfYear,
                repeatThrough,
                importance,
                difficulty
            ).collect {
                when (it) {
                    is State.Error -> {
                        _taskState.value = UiState.Error
                        _taskMessage.value = it.message
                    }

                    is State.Loading -> _taskState.value = UiState.Loading

                    is State.Success -> {
                        _taskState.value = UiState.Success
                    }

                    is State.Empty -> {
                        _taskState.value = UiState.Empty
                    }
                }
            }
        }
    }
    fun updateTask(
        taskId: Int,
        title: String? = "",
        info: String? = null,
        status: Status?,
        startDate: Date? = null,
        finDate: Date? = null,
        repeatEveryDayOfWeek: Weekday? = null,
        repeatEveryDayOfMonth: Int? = null, //от 1 до 31
        repeatEveryDayOfYear: Int? = null, // от 1 до 366
        repeatThrough: Date? = null,
        importance: Int? = null,
        difficulty: Int? = null
    ) {
        viewModelScope.launch {
            createUseCase.updateTask(
                taskId,
                title,
                info,
                status,
                startDate,
                finDate,
                repeatEveryDayOfWeek,
                repeatEveryDayOfMonth,
                repeatEveryDayOfYear,
                repeatThrough,
                importance,
                difficulty
            ).collect {
                when (it) {
                    is State.Error -> {
                        _taskState.value = UiState.Error
                        _taskMessage.value = it.message
                    }

                    is State.Loading -> _taskState.value = UiState.Loading

                    is State.Success -> {
                        _taskState.value = UiState.Success
                    }

                    is State.Empty -> {
                        _taskState.value = UiState.Empty
                    }
                }
            }
        }
    }
}