package com.karimsinouh.national.ui.nationalExams

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.karimsinouh.national.R
import com.karimsinouh.national.data.NationalExam
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.ui.viewExam.ViewExamActivity
import com.karimsinouh.national.util.ScreenState
import com.karimsinouh.national.util.reusableComposables.CenterProgress
import com.karimsinouh.national.util.reusableComposables.MessageScreen
import com.karimsinouh.national.util.reusableComposables.RoundedButton

@Composable
fun MainActivity.NationalExams(
    examsVm:NationalExamsViewModel= hiltViewModel()
) {

    SideEffect {
        examsVm.loadExams(vm.examsUrl)
    }

    when(examsVm.examsState){
        ScreenState.ERROR -> MessageScreen(
            title = stringResource(R.string.error_happened),
            text = vm.subjectsState.message?.message?:"",
            button = {
                RoundedButton(text = stringResource(R.string.got_it)) {
                    nav.popBackStack()
                }
            }
        )
        ScreenState.PROGRESS -> CenterProgress()
        ScreenState.SUCCESS -> Unit
        ScreenState.IDLE -> Content(examsVm.exams)
    }

}

@Composable
private fun MainActivity.Content(exams:List<NationalExam>){
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(exams){exam->
            ExamItem(exam){
                ViewExamActivity.open(this@Content,exam,it)
            }
        }
    }
}