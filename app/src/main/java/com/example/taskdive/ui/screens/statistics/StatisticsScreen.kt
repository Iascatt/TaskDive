package com.example.taskdive.ui.screens.statistics

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.taskdive.ui.screens.current.CurrentTasksView
import com.example.taskdive.ui.screens.current.CurrentTasksViewModel

class StatisticsScreen(
    private val viewModel: StatisticsViewModel
): Screen {
    @Composable
    override fun Content() {
        StatisticsView(viewModel)
    }
}