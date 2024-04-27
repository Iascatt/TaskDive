package com.example.taskdive.ui.screens.current

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class CurrentTasksScreen(
    private val viewModel: CurrentTasksViewModel
): Screen {
    @Composable
    override fun Content() {
        CurrentTasksView(viewModel)
    }
}