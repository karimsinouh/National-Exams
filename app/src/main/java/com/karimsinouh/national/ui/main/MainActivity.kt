package com.karimsinouh.national.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.karimsinouh.national.ui.theme.NationalTheme
import com.karimsinouh.national.util.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var nav:NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            nav= rememberNavController()
            Content()
        }
    }


    @Composable
    private fun Content() {
        NationalTheme {

            window.statusBarColor=MaterialTheme.colors.surface.toArgb()

            Scaffold(
                backgroundColor = MaterialTheme.colors.background,
                topBar = { MainTopBar() },
                content={ MainNavHost() },
                bottomBar = {
                    MainBottomBar(
                        selectedRoute = nav.currentDestination?.route ?: Screens.Home.route,
                        onNavigation = {
                            nav.navigate(it.route){
                                popUpTo(Screens.Home.route)
                            }
                        }
                    )
                }
            )

        }
    }
}
