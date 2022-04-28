package com.karimsinouh.national.ui.exams

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karimsinouh.national.data.Exam
import com.karimsinouh.national.data.source.GetExams
import com.karimsinouh.national.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamsViewModel @Inject constructor(
    private val repo:GetExams
):ViewModel() {

    val exams = mutableStateListOf<Exam>()
    var examsState by mutableStateOf(ScreenState.PROGRESS)

    fun loadExams(url:String?)=viewModelScope.launch{
        delay(1000)

        if (url==null)
            examsState= ScreenState.ERROR.apply {
                message = Throwable("Something went wrong")
            }

        else
            repo(url){result ->

                result.onSuccess {
                    exams.clear()
                    exams.addAll(it)
                    examsState= ScreenState.IDLE
                }

                result.onFailure {
                    examsState= ScreenState.ERROR.apply {
                        message = it
                    }
                }

            }

    }

}