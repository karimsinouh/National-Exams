package com.karimsinouh.national.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karimsinouh.national.data.Subject
import com.karimsinouh.national.data.source.ExamsRepository
import com.karimsinouh.national.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: ExamsRepository
) :ViewModel() {

    val subjects = mutableStateListOf<Subject>()
    var subjectsState by mutableStateOf(ScreenState.PROGRESS)

    init {
        loadSubjects()
    }

    private fun loadSubjects()=viewModelScope.launch {
        repo.getSubjects{

            it.onSuccess {
                subjects.addAll(it)
                subjectsState=ScreenState.IDLE
            }

            it.onFailure {
                subjectsState=ScreenState.ERROR.apply { message=it }
            }

        }
    }

}