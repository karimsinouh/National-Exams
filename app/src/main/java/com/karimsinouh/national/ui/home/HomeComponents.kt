package com.karimsinouh.national.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun SubjectItem() {
    Card {
        Row(
            modifier=Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text(
                text = "Idk what subject this is",
                modifier = Modifier.weight(0.9f)
            )

            Image(
                imageVector = Icons.Outlined.Edit,
                contentDescription = null,
            )
        }
    }
}