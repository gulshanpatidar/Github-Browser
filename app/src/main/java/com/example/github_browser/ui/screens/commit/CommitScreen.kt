package com.example.github_browser.ui.screens.commit

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun CommitScreen(navController: NavHostController,viewModel: CommitViewModel,branchName: String) {
    Text(text = "this branch is $branchName")
}