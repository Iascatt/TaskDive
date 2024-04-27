package com.example.taskdive.ui.screens.current.components
/*
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskdive.domain.models.Tag
import com.example.taskdive.domain.models.Task
import kotlinx.coroutines.launch

@Composable
fun TaskCard(
    task: Task,
    tags: List<Tag>,
    countSubTasks: Int?,
    level: Int = 0
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp.times(level),
                end = 10.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(7f)
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = task.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
           PlantImage(
                modifier = Modifier
                    .weight(5f)
                    .padding(vertical = 15.dp, horizontal = 5.dp)
                    .aspectRatio(ratio = 1f)
                    .clip(RoundedCornerShape(5.dp)),
                imageUrl = "https://milchenko.online/api/custom/plants/${customPlant.id}/image",
            )
        }
        IconButton(
            onClick = {
                navigator.push(
                    CustomCreateScreen(
                        viewModel = viewModel,
                        isCreate = false,
                        isEdit = true,
                        id = customPlant.id
                    )
                )
            },
            content = {
                Icon(
                    painter = rememberVectorPainter(Icons.Default.Edit),
                    contentDescription = null,
                    tint = Color.Black
                )
            },
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.TopEnd)
                .size(20.dp)
        )

        IconButton(
            onClick = {
                scope.launch {
                    customPlant.id?.let { viewModel.delCustomPlant(it) }
                    viewModel.message.collect {
                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                    }
                }
            },
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.BottomEnd)
                .size(20.dp)
        ) {
            Icon(
                painter = rememberVectorPainter(image = Icons.Default.Delete),
                contentDescription = null
            )
        }
    }
}*/