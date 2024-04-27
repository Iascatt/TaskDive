package com.example.taskdive.ui.screens.common.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskdive.management.NavbarManager
import org.koin.compose.koinInject

@Composable
fun TabView(
    navbarManager: NavbarManager = koinInject(),
    content: @Composable() (BoxScope.() -> Unit),

) {
    navbarManager.showNavbar()

    Box(
        modifier = Modifier.systemBarsPadding()
            .fillMaxSize()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp,
            ),
        content = content
    )
}