package com.example.taskdive.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AutoGraph
import androidx.compose.material.icons.outlined.Checklist
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskdive.ui.screens.statistics.StatisticsTab
import com.example.taskdive.ui.screens.current.CurrentTasksTab
import com.example.taskdive.ui.screens.profile.ProfileTab
import com.example.taskdive.ui.screens.task.create.CreateTaskTab

@Composable
@Preview(showBackground = false)
fun TabNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 10.dp
    ) {
        TabNavigationItem(
            CurrentTasksTab,
            rememberVectorPainter(Icons.Filled.Checklist),
            rememberVectorPainter(Icons.Outlined.Checklist)
        )
        TabNavigationItem(
            StatisticsTab,
            rememberVectorPainter(Icons.Filled.AutoGraph),
            rememberVectorPainter(Icons.Outlined.AutoGraph)
        )
        TabNavigationItem(
            CreateTaskTab,
            rememberVectorPainter(Icons.Filled.Create),
            rememberVectorPainter(Icons.Outlined.Create)
        )
        TabNavigationItem(
            ProfileTab,
            rememberVectorPainter(Icons.Filled.Settings),
            rememberVectorPainter(Icons.Outlined.Settings)
        )
    }
}