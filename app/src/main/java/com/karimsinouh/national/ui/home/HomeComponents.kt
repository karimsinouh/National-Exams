package com.karimsinouh.national.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.karimsinouh.national.data.Subject

@Composable
fun SubjectItem(
    subject:Subject,
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
                text = subject.name,
                modifier = Modifier.weight(0.9f),
            )

            AsyncImage(
                model=subject.icon,
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
            )
        }
    }
}