package com.example.taskdive.ui.screens.common.screens

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.taskdive.management.NavbarManager
import org.koin.compose.koinInject

@Composable
fun NestedView(
    modifier: Modifier = Modifier,
    onClose: (() -> Unit),
    content: @Composable (BoxScope.() -> Unit),
    navbarManager: NavbarManager = koinInject()
) {
    navbarManager.hideNavbar()
    Box(modifier = modifier.fillMaxSize()) {
        content()
        IconButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = onClose
        ) {
            Icon(
                painter = rememberVectorPainter(Icons.Default.Close),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.systemBarsPadding()
                    .clip(CircleShape)
                    .background(Color.Gray.copy(alpha = 0.1f))
                    .padding(10.dp)
            )
        }
    }
}