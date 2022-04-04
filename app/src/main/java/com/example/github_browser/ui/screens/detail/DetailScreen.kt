package com.example.github_browser.ui.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.github_browser.ui.util.Routes

@Composable
fun DetailScreen(
    navController: NavHostController,
    viewModel: DetailViewModel,
    username: String,
    repoName: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Details")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.padding(8.dp)
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete repository"
                    )
                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "Open in browser"
                    )
                }
            )
        }
    ) {
        var tabIndex by remember {
            mutableStateOf(0)
        }
        val tabData = listOf(
            "Branches",
            "Issues"
        )
        Column {
            TabRow(selectedTabIndex = tabIndex) {
                tabData.forEachIndexed { index, s ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Text(text = s)
                        }
                    )
                }
            }
//            viewModel.getBranches(username, repoName)
            viewModel.getIssues(username, repoName)
            if (tabIndex == 0) {
                BranchScreen(navController = navController, viewModel = viewModel)
            } else {
                IssueScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun BranchScreen(navController: NavHostController, viewModel: DetailViewModel) {

    val branches = viewModel.branches

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(branches.size) {
            val branch = branches[it]
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(Routes.Commit.route + "/$branch")
                    }
            ) {
                Text(
                    text = branch,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    Text(text = "Hello world from branch")
}

@Composable
fun IssueScreen(viewModel: DetailViewModel) {
    val issues = viewModel.issues
    Text(text = "Hello world from issues")
}