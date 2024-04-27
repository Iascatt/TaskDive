package com.example.taskdive.ui.screens.current.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
fun SearchBox(
    searchText: String?,
    onValueChange: (String) -> Unit,
    label: String?
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchText ?: "",
        onValueChange = onValueChange,
        label = { label?.let { Text(it) } },
        leadingIcon = {
            Icon(
                painter = rememberVectorPainter(Icons.Default.Search),
                contentDescription = "search"
            )
        }
    )
}