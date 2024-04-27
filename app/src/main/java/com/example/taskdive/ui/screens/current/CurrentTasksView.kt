package com.example.taskdive.ui.screens.current

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.example.taskdive.ui.screens.common.screens.TabView
import com.example.taskdive.ui.screens.current.components.FilterButton
import com.example.taskdive.ui.screens.current.components.SearchBox

@Composable
fun CurrentTasksView(viewModel: CurrentTasksViewModel) {


    TabView {
        Column {
            Row {
                FilterButton(onClick = { }, isEnabled = false)
                SearchBox(
                    searchText = null,
                    onValueChange = {},
                    label = "Поиск задачи"
                )
            }
            
        }
    }
}