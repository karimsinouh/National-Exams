package com.karimsinouh.national.ui.viewExam

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karimsinouh.national.data.pdf.GetPdf
import com.karimsinouh.national.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class ViewExamViewModel @Inject constructor(
    private val getPdf: GetPdf,
):ViewModel() {

    var pdf by mutableStateOf<InputStream?>(null)
    var state by mutableStateOf(ScreenState.PROGRESS)

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

}