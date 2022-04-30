package com.karimsinouh.national.util

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import com.karimsinouh.national.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DownloadPfd @Inject constructor(
    @ApplicationContext private val context:Context,
    private val downloadManager: DownloadManager
) {


    operator fun invoke(url:String,title:String):Long{
        val uri = Uri.parse(url)
        val request = DownloadManager.Request(uri)

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOCUMENTS, "$title.pdf")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDescription(context.getString(R.string.downloading_exam))
        request.setTitle(title)

        return downloadManager.enqueue(request)
    }

}