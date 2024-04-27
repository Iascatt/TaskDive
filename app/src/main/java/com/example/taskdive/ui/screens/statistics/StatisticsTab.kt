package com.example.taskdive.ui.screens.statistics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.taskdive.R
import com.example.taskdive.ui.screens.current.CurrentTasksScreen
import org.koin.androidx.compose.getViewModel

object StatisticsTab: Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(R.string.tasks)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(StatisticsScreen(getViewModel()))
    }
}