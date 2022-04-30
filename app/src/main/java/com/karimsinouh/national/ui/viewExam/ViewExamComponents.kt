package com.karimsinouh.national.ui.viewExam

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import com.karimsinouh.national.R
import com.karimsinouh.national.util.reusableComposables.MessageScreen
import java.io.InputStream

@Composable
fun ViewExamTopBar(
    title: String,
    onBackPressed: () -> Unit,
    onDownload: () -> Unit,
    downloaded: Boolean,
) {

    Column{

        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(8.dp)
                .fillMaxWidth()
        ) {


            IconButton(onClick = onBackPressed) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize=18.sp,
                modifier= Modifier
                    .fillMaxWidth()
                    .weight(0.9f)
            )

            IconButton(onClick = { if (!downloaded) onDownload() }) {

                AnimatedVisibility(visible = downloaded) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = null)
                }


                AnimatedVisibility(visible = !downloaded) {
                    Icon(painter = painterResource(id = R.drawable.ic_download), contentDescription = null)
                }

            }

        }



        Divider()
    }

}

@Composable
fun PdfReader(stream:InputStream?) {
    if (stream!=null)
        AndroidView(
            factory = {context->
                PDFView(context,null).apply {
                    fromStream(stream).load()
                }
            },
            modifier=Modifier.fillMaxSize()
        )
    else
        MessageScreen(
            title = stringResource(id = R.string.error_happened),
            text = stringResource(id = R.string.try_again)
        )
}

@Composable
fun WebViewPdfReader(url:String) {

    AndroidView(
        factory = {context->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.setSupportZoom(true)
                settings.javaScriptEnabled = true
                loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
            }
        },
        modifier=Modifier.fillMaxSize()
    )

}