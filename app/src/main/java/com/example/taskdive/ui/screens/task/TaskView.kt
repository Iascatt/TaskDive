package com.example.taskdive.ui.screens.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.taskdive.R
import com.example.taskdive.domain.models.Status
import com.example.taskdive.domain.models.Task
import com.example.taskdive.domain.models.Weekday
import com.example.taskdive.ui.screens.UiState
import com.example.taskdive.ui.screens.common.components.Rounding
import com.example.taskdive.ui.screens.common.screens.NestedView
import com.example.taskdive.ui.screens.common.screens.TabView
import com.example.taskdive.ui.screens.current.components.status.DropdownStatusMenu
import org.koin.androidx.compose.getViewModel
import java.util.Date

@Composable
fun TaskView(
    viewModel: TaskViewModel,
    task: Task?,
    mode: Modes
) {
    var title: String by rememberSaveable { mutableStateOf("") }
    var info: String? by rememberSaveable { mutableStateOf(null) }
    var status: Status? by rememberSaveable { mutableStateOf(Status.TO_DO) }
    var startDate: Date? by rememberSaveable { mutableStateOf(null) }
    var finDate: Date? by rememberSaveable { mutableStateOf(null) }
    var repeatEveryDayOfWeek: Weekday? by rememberSaveable { mutableStateOf(null) }
    var repeatEveryDayOfMonth: Int? by rememberSaveable { mutableStateOf(null) }
    var repeatEveryDayOfYear: Int? by rememberSaveable { mutableStateOf(null) }
    var repeatThrough: Date? by rememberSaveable { mutableStateOf(null) }
    var importance: Int? by rememberSaveable { mutableStateOf(null) }
    var difficulty: Int? by rememberSaveable { mutableStateOf(null) }

    if (mode != Modes.CREATE && task != null) {
        title = task.title
        info = task.info
        status = task.status

        startDate = task.startDate
        finDate = task.finDate
        repeatEveryDayOfWeek = task.repeatEveryDayOfWeek
        repeatEveryDayOfMonth = task.repeatEveryDayOfMonth
        repeatEveryDayOfYear = task.repeatEveryDayOfYear
        repeatThrough = task.repeatThrough
        importance = task.importance
        difficulty = task.difficulty
    }

    fun resetFields() {
        title = ""
        info = null
        startDate = null
        finDate = null
        repeatEveryDayOfWeek = null
        repeatEveryDayOfMonth = null
        repeatEveryDayOfYear = null
        repeatThrough = null
        importance = null
        difficulty = null
    }

    val tasksState = viewModel.taskState.collectAsState()
    val message by viewModel.taskMessage.collectAsState()

    val localNavigator = LocalNavigator.current


    val editable = (mode != Modes.VIEW)

    TabView {
        Column(
            modifier = Modifier.padding(vertical = 30.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = { title = it },
                label = { Text("Название задачи") },
                shape = Rounding(),
                enabled = editable
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = info ?: "",
                onValueChange = { info = it },
                label = { Text("Подробная информация") },
                shape = Rounding(),
                enabled = editable

            )
            status?.let {
                DropdownStatusMenu(
                    currentStatus = it,
                    onSelect = {
                        if (task != null) {
                            task.taskId?.let { it1 ->
                                viewModel.updateTask(
                                    taskId = it1,
                                    status = it
                                )
                            }
                        }
                    }
                )
            }

            when (mode) {
                Modes.VIEW -> {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            localNavigator?.replace(TaskScreen(task, Modes.EDIT))
                        }) {
                        Text(stringResource(R.string.edit_task))
                    }
                }

                Modes.CREATE -> {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            viewModel.createTask(
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
                            )
                        }) {
                        Text(stringResource(R.string.save_task))
                    }
                }

                Modes.EDIT -> {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            task?.taskId?.let {
                                viewModel.updateTask(
                                    it,
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
                                )
                            }
                        }) {
                        Text(stringResource(R.string.save_changes))
                    }
                }
            }
            when (tasksState.value) {

                UiState.Empty -> {
                    Text("Пустая задача")
                }

                UiState.Success -> {
                    Text("Успех!")
                }

                UiState.Error -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        message?.let { Text(it) }
                    }
                }

                UiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                UiState.NotLoading -> {
                }
            }
        }
    }
}
