package com.example.taskdive.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.taskdive.management.NavbarManager
import com.example.taskdive.ui.navigation.TabNavigationBar
import com.example.taskdive.ui.screens.current.CurrentTasksTab
import org.koin.compose.koinInject

class BaseScreen: Screen {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        TabNavigator(CurrentTasksTab) {
            Scaffold(
                content = { innerPadding ->
                    Box(
                        modifier = Modifier.padding(
                            PaddingValues(
                                bottom = innerPadding.calculateBottomPadding()
                            )
                        )
                    ) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    val navbarManager: NavbarManager = koinInject()
                    if (navbarManager.navbarState.value)
                        TabNavigationBar()
                }
            )
        }
    }
}