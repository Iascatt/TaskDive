package com.example.taskdive.di

import com.example.taskdive.domain.usecases.create.CreateTaskUseCase
import com.example.taskdive.domain.usecases.list.TaskListUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { TaskListUseCase(get()) }
    single { CreateTaskUseCase(get()) }

}