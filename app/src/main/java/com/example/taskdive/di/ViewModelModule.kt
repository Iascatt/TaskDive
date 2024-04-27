package com.example.taskdive.di

import com.example.taskdive.ui.screens.current.CurrentTasksViewModel
import com.example.taskdive.ui.screens.profile.ProfileViewModel
import com.example.taskdive.ui.screens.statistics.StatisticsViewModel
import com.example.taskdive.ui.screens.task.create.CreateTaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CurrentTasksViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { StatisticsViewModel() }
    viewModel { CreateTaskViewModel() }

}