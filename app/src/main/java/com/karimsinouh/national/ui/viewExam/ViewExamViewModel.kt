package com.karimsinouh.national.ui.viewExam

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karimsinouh.national.data.base.ExamEntity
import com.karimsinouh.national.data.base.ExamsDatabase
import com.karimsinouh.national.data.pdf.GetPdf
import com.karimsinouh.national.util.ScreenState
import com.karimsinouh.national.util.ads.GetAdRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class ViewExamViewModel @Inject constructor(
    private val getPdf: GetPdf,
    private val database: ExamsDatabase,
    @ApplicationContext private val context: Context
):ViewModel() {

    val adRequest=GetAdRequest(context)

    var pdf by mutableStateOf<InputStream?>(null)
    var state by mutableStateOf(ScreenState.PROGRESS)
    var downloadId by mutableStateOf<Long>(1)

    fun loadStream(url:String){
        if (pdf==null)
            getPdf.remote(url){result ->

                result.onSuccess {
                    pdf=it
                    state=ScreenState.IDLE
                }

                result.onFailure {
                    state=ScreenState.ERROR.apply { message=it }
                }

            }
    }

    fun download(url:String,title:String){
        downloadId=getPdf.downloadPfd(url, title)
        storeInDatabase(title)
    }

    private fun storeInDatabase(title:String)=viewModelScope.launch{
        delay(100)
        val item=ExamEntity(title,downloadId)
        database.downloadedExams().insert(item)
    }

}