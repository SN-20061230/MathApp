package com.example.mathkids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mathgame.Navigation.AppNavigation
import com.example.mathkids.ui.theme.MathKidsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathKidsTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
