package com.karimsinouh.national.ui.downloads

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.R
import com.karimsinouh.national.data.base.ExamEntity

@Composable
fun DownloadedItem(
    item:ExamEntity,
    onClick:()->Unit
) {
    Card {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.title,
                modifier = Modifier.weight(0.9f),
            )

            Icon(painter = painterResource(id = R.drawable.ic_download), contentDescription = null)
        }
    }
}