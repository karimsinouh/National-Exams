package com.karimsinouh.national.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karimsinouh.national.ui.home.Home
import com.karimsinouh.national.util.Screens

@Composable
fun MainActivity.MainNavHost() {
    NavHost(
        navController = nav,
        startDestination = Screens.Home.route
    ){

        composable(
            route=Screens.Home.route
        ){
            Home()
        }

    }
}