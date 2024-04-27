package com.example.taskdive.di

import com.example.taskdive.ui.screens.current.CurrentTasksViewModel
import com.example.taskdive.ui.screens.profile.ProfileViewModel
import com.example.taskdive.ui.screens.statistics.StatisticsViewModel
import com.example.taskdive.ui.screens.task.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CurrentTasksViewModel(get()) }
    viewModel { ProfileViewModel() }
    viewModel { StatisticsViewModel() }
    viewModel { TaskViewModel(get()) }
}