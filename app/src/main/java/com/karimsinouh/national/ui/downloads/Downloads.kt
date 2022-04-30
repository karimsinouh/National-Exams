package com.karimsinouh.national.ui.downloads

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.R
import com.karimsinouh.national.data.base.ExamEntity
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.util.reusableComposables.MessageScreen

@Composable
fun MainActivity.Downloads() {
    val exams = vm.downloadedExams.observeAsState().value?: emptyList()

    if (exams.isEmpty())
        MessageScreen(title = stringResource(id = R.string.downloads), text = stringResource(R.string.no_downloads))
    else
        Content(exams)

}


@Composable
private fun MainActivity.Content(exams:List<ExamEntity>){
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(exams){exam->
            DownloadedItem(item = exam) {

            }
        }
    }
}