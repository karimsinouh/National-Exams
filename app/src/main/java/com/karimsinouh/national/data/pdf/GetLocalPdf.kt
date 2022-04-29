package com.karimsinouh.national.data.pdf

import android.net.Uri
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetLocalPdf @Inject constructor() {

    operator fun invoke(uri:Uri,listener:(Result<InputStream>)->Unit){

    }

}