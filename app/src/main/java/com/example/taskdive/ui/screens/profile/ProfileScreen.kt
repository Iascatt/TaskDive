package com.example.taskdive.ui.screens.profile

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.taskdive.ui.screens.current.CurrentTasksViewModel

class ProfileScreen(
    private val viewModel: ProfileViewModel
): Screen {
    @Composable
    override fun Content() {
        ProfileView(viewModel)
    }
}