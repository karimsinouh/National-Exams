package com.karimsinouh.national.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.ui.main.MainActivity

@Composable
fun MainActivity.Home() {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ){

        items(20){
            SubjectItem()
        }
    }

}