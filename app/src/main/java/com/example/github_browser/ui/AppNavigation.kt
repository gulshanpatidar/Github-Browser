package com.example.github_browser.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.github_browser.ui.screens.add_repo.AddRepoScreen
import com.example.github_browser.ui.screens.detail.DetailScreen
import com.example.github_browser.ui.screens.home.HomeScreen
import com.example.github_browser.ui.util.Routes

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Home.route){

        composable(route = Routes.Home.route){
            HomeScreen(navController = navController)
        }

        composable(route = Routes.Detail.route){
            DetailScreen(navController = navController)
        }

        composable(route = Routes.AddRepo.route){
            AddRepoScreen(navController = navController)
        }
    }
}