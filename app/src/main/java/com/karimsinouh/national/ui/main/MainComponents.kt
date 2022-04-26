package com.karimsinouh.national.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karimsinouh.national.R
import com.karimsinouh.national.util.Screens

@Composable
fun MainTopBar() {
    Column {

        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize=18.sp,
            modifier= Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(12.dp)
        )

        Divider()
    }
}

@Composable
fun MainBottomBar(
    selectedRoute:String,
    onNavigation:(Screens)->Unit
) {
    Column {
        Divider()
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 0.dp
        ) {

            Screens.Get.bottomNavigationItems.forEach { screen->

                val isSelected=selectedRoute==screen.route

                BottomNavigationItem(
                    selected = isSelected,
                    onClick = { onNavigation(screen)},
                    icon = {
                        if (screen.imageVector!=null)
                            Icon(imageVector = screen.imageVector, contentDescription = null)
                        else if (screen.drawable!=null)
                            Icon(painter = painterResource(id = screen.drawable),contentDescription = null)
                    },
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = MaterialTheme.colors.onSurface,
                    label = {
                        Text(text = stringResource(id = screen.title))
                    },
                    alwaysShowLabel = false
                )

            }

        }
    }
}