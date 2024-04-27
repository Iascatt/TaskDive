package com.example.taskdive.di

import com.example.taskdive.management.NavbarManager
import org.koin.dsl.module

val managementModule = module {
    single { NavbarManager() }
}