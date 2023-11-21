package com.example.mathgame.Navigation

import GameScreen
import HomeScreen
import MODE_KEY
import NAME_KEY
import NameScreen
import ResultScreen
import SCORE_KEY
import TASKS_KEY
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import com.example.mathgame.Screen.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.Name.route, arguments = listOf(navArgument(MODE_KEY) {
            type = NavType.StringType
        })) { navBackStackEntry ->
            val mode = navBackStackEntry.arguments?.getString(MODE_KEY)
            if (mode != null) {
                NameScreen(navController, mode = mode)
            }
        }
        composable(
            route = Screens.Game.route, arguments = listOf(
                navArgument(MODE_KEY) {
                    type = NavType.StringType
                },
                navArgument(NAME_KEY) {
                    type = NavType.StringType
                },
            )
        ) { navBackStackEntry ->
            val mode = navBackStackEntry.arguments?.getString(MODE_KEY)
            val name = navBackStackEntry.arguments?.getString(NAME_KEY)
            if (mode != null && name != null) {
                GameScreen(navController, mode = mode, name = name)
            }
        }
        composable(
            route = Screens.Result.route, arguments = listOf(
                navArgument(SCORE_KEY) {
                    type = NavType.IntType
                },
                navArgument(TASKS_KEY) {
                    type = NavType.IntType
                },
            )
        ) { navBackStackEntry ->
            val score = navBackStackEntry.arguments?.getInt(SCORE_KEY)
            val tasks = navBackStackEntry.arguments?.getInt(TASKS_KEY)
            if (tasks != null && score != null) {
                ResultScreen(score = score, tasks = tasks)
            }
        }
    }
}