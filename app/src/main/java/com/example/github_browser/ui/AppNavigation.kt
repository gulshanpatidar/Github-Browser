package com.example.github_browser.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.github_browser.ui.screens.add_repo.AddRepoScreen
import com.example.github_browser.ui.screens.commit.CommitScreen
import com.example.github_browser.ui.screens.commit.CommitViewModel
import com.example.github_browser.ui.screens.detail.DetailScreen
import com.example.github_browser.ui.screens.detail.DetailViewModel
import com.example.github_browser.ui.screens.home.HomeScreen
import com.example.github_browser.ui.screens.home.HomeViewModel
import com.example.github_browser.ui.util.Routes

@Composable
fun AppNavigation(navController: NavHostController) {

    //create an single instance of homeViewModel
    val homeViewModel = viewModel<HomeViewModel>()
    val detailViewModel = viewModel<DetailViewModel>()
    val commitViewModel = viewModel<CommitViewModel>()

    //create and navHost and add the different screens to it.
    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(route = Routes.Home.route) {

            HomeScreen(navController = navController, viewModel = homeViewModel)
        }

        composable(
            route = Routes.Detail.route + "/{username}/{repoName}",
            arguments = listOf(
                navArgument(name = "username") {
                    NavType.StringType
                },
                navArgument(name = "repoName") {
                    NavType.StringType
                }
            )
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username").toString()
            val repoName = backStackEntry.arguments?.getString("repoName").toString()
            DetailScreen(
                navController = navController,
                viewModel = detailViewModel,
                username = username,
                repoName = repoName
            )
        }

        composable(route = Routes.AddRepo.route) {
            AddRepoScreen(navController = navController, viewModel = homeViewModel)
        }

        composable(
            route = Routes.Commit.route + "{branchName}",
            arguments = listOf(
                navArgument("branchName"){
                    NavType.StringType
                }
            )
        ) { backStackEntry ->
            val branchName = backStackEntry.arguments?.getString("branchName").toString()
            CommitScreen(navController = navController, viewModel = commitViewModel, branchName = branchName)
        }
    }
}