package com.karimsinouh.national.ui.main

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karimsinouh.national.data.Subject
import com.karimsinouh.national.data.nationalExams.NationalExamsRepository
import com.karimsinouh.national.util.ScreenState
import com.karimsinouh.national.util.ads.GetAdRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: NationalExamsRepository,
    private val downloadManager: DownloadManager,
    @ApplicationContext private val context:Context
) :ViewModel() {

    val adRequest=GetAdRequest(context)

    var examsUrl:String? = null

    val subjects = mutableStateListOf<Subject>()
    var subjectsState by mutableStateOf(ScreenState.PROGRESS)

    val downloadedExams=repo.database.downloadedExams().getAllDownloadedExams()

    init {
        loadSubjects()
    }

    private fun loadSubjects()=viewModelScope.launch {
        delay(500)
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

    fun getUri(id:Long): Uri {
        return downloadManager.getUriForDownloadedFile(id)
    }

}