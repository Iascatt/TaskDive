package com.example.taskdive.ui.screens.current.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@Composable
fun FilterButton(
    onClick: () -> Unit,
    isEnabled: Boolean
) {
    IconButton(
        onClick = onClick,
        enabled = isEnabled
    ) {
        Icon(
            painter = rememberVectorPainter(Icons.Default.FilterAlt),
            contentDescription = "filter"
        )
    }
}