package com.karimsinouh.national.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.R
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.util.ScreenState
import com.karimsinouh.national.util.Screens
import com.karimsinouh.national.util.reusableComposables.CenterProgress
import com.karimsinouh.national.util.reusableComposables.MessageScreen

@Composable
fun MainActivity.Home() {

    when(vm.subjectsState){
        ScreenState.ERROR -> MessageScreen(
            title = stringResource(R.string.error_happened),
            text = vm.subjectsState.message?.message?:""
        )
        ScreenState.PROGRESS -> CenterProgress()
        ScreenState.SUCCESS -> Unit
        ScreenState.IDLE -> Content()
    }

}

@Composable
private fun MainActivity.Content() {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ){

        items(
            items = vm.subjects,
        ){item->
            SubjectItem(item){
                vm.examsUrl=item.url
                nav.navigate(Screens.Exams.route)
            }
        }

    }

}