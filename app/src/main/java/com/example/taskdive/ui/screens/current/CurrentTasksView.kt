package com.example.taskdive.ui.screens.current

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.taskdive.R
import com.example.taskdive.ui.screens.UiState
import com.example.taskdive.ui.screens.common.components.TaskCard
import com.example.taskdive.ui.screens.common.screens.TabView
import com.example.taskdive.ui.screens.current.components.AddTaskButton
import com.example.taskdive.ui.screens.current.components.FilterButton
import com.example.taskdive.ui.screens.current.components.SearchBox
import com.example.taskdive.ui.screens.task.TaskTab

@Composable
fun CurrentTasksView(viewModel: CurrentTasksViewModel) {
    LaunchedEffect(Unit) {
        viewModel.getAllTasks()
    }
    val tasksState = viewModel.tasksState.collectAsState()
    val tasks by viewModel.tasks.collectAsState()
    val message by viewModel.tasksMessage.collectAsState()
    var searchText by rememberSaveable { mutableStateOf("") }

    val tabNavigator = LocalTabNavigator.current

    TabView {
        Column {
            Row {
                FilterButton(onClick = { }, isEnabled = false)
                SearchBox(
                    searchText = searchText,
                    onValueChange = {
                        searchText = it
                        viewModel.getAllTasks(searchText)
                    },
                    label = "Поиск задачи"
                )
            }

            when (tasksState.value) {

                UiState.Empty -> {
                    Text(stringResource(R.string.empty_list))
                }

                UiState.Success -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(tasks.size) { index ->
                                TaskCard(tasks[index])
                            }
                        }
                    }
                }

                UiState.Error -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        message?.let { Text(it) }
                        Button(onClick = { viewModel.getAllTasks() }) {
                            Text(stringResource(id = R.string.retry))
                        }
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

                else -> {}
            }

            AddTaskButton(onClick = { tabNavigator.current = TaskTab })
        }
    }
}