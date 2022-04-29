package com.karimsinouh.national.ui.viewExam

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import com.karimsinouh.national.R
import com.karimsinouh.national.data.Exam
import com.karimsinouh.national.ui.theme.NationalTheme
import com.karimsinouh.national.util.ScreenState
import com.karimsinouh.national.util.reusableComposables.CenterProgress
import com.karimsinouh.national.util.reusableComposables.MessageScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewExamActivity: ComponentActivity() {

    companion object{

        fun open(context:Context,exam:Exam,normal:Boolean){
            val intent= Intent(context,ViewExamActivity::class.java)
            intent.apply {
                val term=if (normal) context.getString(R.string.normal) else context.getString(R.string.rattrapage)

                val title=exam.name + " - " + term
                putExtra("title",title)

                val url=if (normal) exam.normal else exam.rattrapage
                putExtra("url",url)
            }
            context.startActivity(intent)
        }

    }

    private lateinit var title:String
    private lateinit var url:String

    private val vm by viewModels<ViewExamViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Content()

        }

        title=intent.getStringExtra("title")?:""
        url=intent.getStringExtra("url")?:""

        vm.loadStream(url)

    }

    @Composable
    private fun Content() {
        NationalTheme {

            window.statusBarColor=MaterialTheme.colors.surface.toArgb()

            Scaffold(
                topBar = {TopBar()},
                backgroundColor = MaterialTheme.colors.background
            ) {

                when(vm.state){
                    ScreenState.IDLE -> PdfReader(stream = vm.pdf)
                    ScreenState.PROGRESS -> CenterProgress()
                    ScreenState.SUCCESS -> Unit
                    ScreenState.ERROR -> ErrorMessage()
                }

            }

        }
    }

    @Composable
    private fun ErrorMessage() {
        MessageScreen(
            title = stringResource(id = R.string.error_happened),
            text = vm.state.message?.message ?: stringResource(id = R.string.try_again)
        )
    }

    @Composable
    private fun TopBar(){
        ViewExamTopBar(
            title = title,
            onBackPressed = ::finish,
            onDownload = {}
        )
    }

}