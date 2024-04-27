package com.example.taskdive.ui.screens.task

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.taskdive.domain.models.Task
import org.koin.androidx.compose.getViewModel

class TaskScreen(
    private val task: Task? = null,
    private val mode: Modes = Modes.CREATE
): Screen {
    @Composable
    override fun Content() {
        TaskView(getViewModel(), task, mode)
    }
}