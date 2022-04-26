package com.karimsinouh.national.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karimsinouh.national.R

@Composable
fun MainTopBar() {
    Column {

        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize=18.sp,
            modifier=Modifier.fillMaxWidth().background(MaterialTheme.colors.surface).padding(12.dp)
        )

        Divider()
    }
}