package com.karimsinouh.national.ui.exams

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.util.ScreenState

@Composable
fun MainActivity.Exams() {

    SideEffect {
        vm.loadExams()
    }

    when(vm.examsState){
        ScreenState.ERROR -> Text(vm.examsState.message?.message?:"idfk")
        ScreenState.PROGRESS -> CircularProgressIndicator()
        ScreenState.SUCCESS -> Unit
        ScreenState.IDLE -> Content()
    }

}

@Composable
private fun MainActivity.Content(){
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(vm.exams){exam->
            ExamItem(exam = exam) {

            }
        }
    }
}