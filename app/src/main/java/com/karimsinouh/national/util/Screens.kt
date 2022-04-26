package com.karimsinouh.national.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.karimsinouh.national.R

sealed class Screens(
    val route:String,
    @StringRes val title:Int,
    val imageVector: ImageVector?=null,
    @DrawableRes val drawable:Int?=null
) {

    object Home:Screens("home", R.string.home, Icons.Default.Home)
    object Downloads:Screens("downloads", R.string.downloads, drawable = R.drawable.ic_download)
    object Menu:Screens("menu",R.string.more,Icons.Default.Menu)

    object Get {
        val bottomNavigationItems= listOf(Home,Downloads,Menu)
    }

}