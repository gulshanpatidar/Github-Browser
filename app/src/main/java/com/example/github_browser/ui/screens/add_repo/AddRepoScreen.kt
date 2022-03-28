package com.example.github_browser.ui.screens.add_repo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.github_browser.ui.components.ScaffoldUse
import com.example.github_browser.ui.screens.home.HomeViewModel

@Composable
fun AddRepoScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    ScaffoldUse(topBarTitle = "Add Repo", onClickTopButton = { navController.navigateUp() }) {

        var ownerName by remember {
            mutableStateOf("")
        }

        var repoName by remember {
            mutableStateOf("")
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Owner / Organization",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(value = ownerName, onValueChange = {
                    ownerName = it
                })
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Repo Name",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                TextField(value = repoName, onValueChange = {
                    repoName = it
                })
            }
            Button(
                onClick = {
                    viewModel.addRepo(
                        username = ownerName,
                        repoName = repoName
                    )
                    navController.navigateUp()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(text = "ADD")
            }
        }
    }
}