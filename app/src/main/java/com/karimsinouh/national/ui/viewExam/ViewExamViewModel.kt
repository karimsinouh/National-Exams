package com.karimsinouh.national.ui.viewExam

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.karimsinouh.national.data.pdf.GetPdf
import com.karimsinouh.national.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class ViewExamViewModel @Inject constructor(
    private val getPdf: GetPdf,
):ViewModel() {

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
    }

}