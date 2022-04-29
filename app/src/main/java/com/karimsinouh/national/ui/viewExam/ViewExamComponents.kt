package com.karimsinouh.national.ui.viewExam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karimsinouh.national.R

@Composable
fun ViewExamTopBar(
    title:String,
    onBackPressed:()->Unit,
    onDownload:()->Unit,
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

            IconButton(onClick = onDownload) {
                Icon(painter = painterResource(id = R.drawable.ic_download), contentDescription = null)
            }

        }



        Divider()
    }

}