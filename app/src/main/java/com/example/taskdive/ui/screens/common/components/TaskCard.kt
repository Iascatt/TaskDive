package com.example.taskdive.ui.screens.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.taskdive.domain.models.Status
import com.example.taskdive.domain.models.Task
import com.example.taskdive.ui.screens.current.components.status.DropdownStatusMenu
import com.example.taskdive.ui.screens.task.Modes
import com.example.taskdive.ui.screens.task.TaskScreen
import com.example.taskdive.ui.screens.task.TaskViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun TaskCard(
    task: Task,
) {
    val navigator = LocalNavigator.current
    val taskViewModel: TaskViewModel = getViewModel()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { navigator?.push(TaskScreen(task, Modes.VIEW)) }
            .padding(10.dp),
        shape = Rounding(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(5f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = task.title,
                        fontStyle = MaterialTheme.typography.titleMedium.fontStyle
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    DropdownStatusMenu(
                        currentStatus = task.status,
                        onSelect = {
                                taskViewModel.updateTask(
                                    taskId = task.taskId!!,
                                    status = it
                                )
                        }
                    )
                }
            }

        }
    }
}