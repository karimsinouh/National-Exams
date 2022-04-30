package com.karimsinouh.national.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.karimsinouh.national.ui.downloads.Downloads
import com.karimsinouh.national.ui.exams.Exams
import com.karimsinouh.national.ui.home.Home
import com.karimsinouh.national.ui.viewOfflineExam.ViewOfflineExam
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

        composable(
            route=Screens.Exams.route
        ){
            Exams()
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


    }
}