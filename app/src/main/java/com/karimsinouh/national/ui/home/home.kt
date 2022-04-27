package com.karimsinouh.national.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.util.ScreenState

@Composable
fun MainActivity.Home() {

    when(vm.subjectsState){
        ScreenState.ERROR -> Unit
        ScreenState.PROGRESS -> CircularProgressIndicator()
        ScreenState.SUCCESS -> Unit
        ScreenState.IDLE -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(12.dp)
            ){

                items(20){
                    SubjectItem()
                }
            }
        }
    }

}