package com.karimsinouh.national.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.karimsinouh.national.R
import com.karimsinouh.national.ui.downloads.Downloads
import com.karimsinouh.national.ui.nationalExams.NationalExams
import com.karimsinouh.national.ui.home.Home
import com.karimsinouh.national.ui.menu.Menu
import com.karimsinouh.national.ui.viewOfflineExam.ViewOfflineExam
import com.karimsinouh.national.util.Screens
import com.karimsinouh.national.util.ads.AnchoredAdaptiveBanner

@Composable
fun MainActivity.MainNavHost() {

    Column {
        AnchoredAdaptiveBanner(
            adUnitId = stringResource(id = R.string.main_banner),
            adRequest = vm.adRequest
        )
        NavHost(
            navController = nav,
            startDestination = Screens.Home.route
        ){

            composable(
                route=Screens.Home.route
            ){
                Home()
            }

            composable(
                route=Screens.NationalExams.route
            ){
                NationalExams()
            }

            composable(
                route = Screens.Downloads.route
            ){
                Downloads()
            }


            composable(
                route=Screens.ViewOfflineExam.route,
                arguments = listOf(
                    navArgument("id"){type= NavType.LongType}
                )
            ){
                val id=it.arguments?.getLong("id")
                ViewOfflineExam(id = id)
            }

            composable(
                route = Screens.Menu.route
            ){
                Menu()
            }


        }
    }


}