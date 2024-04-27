package com.example.taskdive.ui.screens.current.components.status

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.taskdive.domain.models.Status

@Composable
fun DropdownStatusMenu(
    currentStatus: Status,
    onSelect: (Status) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedStatus by remember {
        mutableStateOf(currentStatus)
    }
    Box {
        StatusIcon(status = selectedStatus, onClick = {expanded = !expanded})
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Status.entries.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    onSelect(Status.entries[index])
                    selectedStatus = Status.entries[index]
                    expanded = false
                },
                    text = { Text(Status.entries[index].name) })
            }
        }
    }
}