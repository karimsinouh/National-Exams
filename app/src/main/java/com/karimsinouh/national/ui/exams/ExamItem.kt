package com.karimsinouh.national.ui.exams

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.karimsinouh.national.data.Exam

@Composable
fun ExamItem(
    exam:Exam,
    onClick:()->Unit
) {
    Card {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = exam.name,
                modifier = Modifier.weight(0.9f),
            )


        }
    }
}