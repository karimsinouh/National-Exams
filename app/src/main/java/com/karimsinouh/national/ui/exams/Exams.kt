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
import androidx.hilt.navigation.compose.hiltViewModel
import com.karimsinouh.national.data.Exam
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.util.ScreenState

@Composable
fun MainActivity.Exams(
    examsVm:ExamsViewModel= hiltViewModel()
) {

    SideEffect {
        examsVm.loadExams(vm.examsUrl)
    }

    when(examsVm.examsState){
        ScreenState.ERROR -> Text(examsVm.examsState.message?.message?:"idfk")
        ScreenState.PROGRESS -> CircularProgressIndicator()
        ScreenState.SUCCESS -> Unit
        ScreenState.IDLE -> Content(examsVm.exams)
    }

}

@Composable
private fun MainActivity.Content(exams:List<Exam>){
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(exams){exam->
            ExamItem(exam = exam) {

            }
        }
    }
}