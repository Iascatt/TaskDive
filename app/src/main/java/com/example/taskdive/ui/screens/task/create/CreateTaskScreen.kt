package com.example.taskdive.ui.screens.task.create

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class CreateTaskScreen(
    private val viewModel: CreateTaskViewModel
): Screen {
    @Composable
    override fun Content() {
        CreateTaskView(viewModel)
    }
}