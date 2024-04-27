package com.example.taskdive.ui.screens.current.components.status

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.IncompleteCircle
import androidx.compose.material.icons.outlined.TimerOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.example.taskdive.domain.models.Status

@Composable
fun StatusIcon(status: Status, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter =
            when(status) {
                Status.TO_DO -> rememberVectorPainter(image = Icons.Outlined.Circle)
                Status.CANCELLED -> rememberVectorPainter(image = Icons.Outlined.Cancel)
                Status.DELAYED -> rememberVectorPainter(image = Icons.Outlined.TimerOff)
                Status.FINISHED -> rememberVectorPainter(image = Icons.Outlined.Check)
                Status.IN_PROGRESS -> rememberVectorPainter(image = Icons.Outlined.IncompleteCircle)
            },
            contentDescription = "status"
        )
    }

}