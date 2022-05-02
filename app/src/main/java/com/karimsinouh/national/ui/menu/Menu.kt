package com.karimsinouh.national.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karimsinouh.national.R
import com.karimsinouh.national.ui.main.MainActivity
import com.karimsinouh.national.util.RateApp
import com.karimsinouh.national.util.reusableComposables.RoundedButton

@Composable
@Preview(showBackground = true)
fun MainActivity.Menu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start=24.dp,end=24.dp, bottom = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ApplicationInfo()
        Spacer(modifier = Modifier.height(24.dp))
        RoundedButton(text = stringResource(id = R.string.rate)) {
            RateApp(this@Menu)
        }
    }
}

@Composable
private fun ApplicationInfo(
    modifier:Modifier=Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_bird_medium),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.app_description), textAlign = TextAlign.Center)
    }
}