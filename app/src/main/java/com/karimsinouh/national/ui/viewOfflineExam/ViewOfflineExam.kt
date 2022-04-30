package com.karimsinouh.national.ui.viewOfflineExam

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.karimsinouh.national.R
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.ui.viewExam.PdfReader
import com.karimsinouh.national.util.reusableComposables.MessageScreen

@Composable
fun MainActivity.ViewOfflineExam(
    id:Long?,
) {
    if (id==null){
        MessageScreen(
            title = stringResource(id = R.string.error_happened),
            text = stringResource(id = R.string.try_again)
        )
        return
    }

    val uri=vm.getUri(id)

    PdfReader(uri = uri)

}