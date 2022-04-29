package com.karimsinouh.national.data.pdf

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetRemotePdf @Inject constructor() {

    operator fun invoke(pdfLink:String,listener:(Result<InputStream>)->Unit){
        CoroutineScope(Dispatchers.IO).launch {
            val stream:InputStream?

            try {
                val url=URL(pdfLink)

                val connection:HttpURLConnection= url.openConnection() as HttpURLConnection

                if (connection.responseCode==200){
                    stream=BufferedInputStream(connection.inputStream)
                    listener(Result.success(stream))
                }

            }catch (e:IOException){
                listener(Result.failure(e))
            }
        }
    }

}