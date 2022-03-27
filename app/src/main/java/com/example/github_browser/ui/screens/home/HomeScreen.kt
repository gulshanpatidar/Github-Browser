package com.example.github_browser.ui.screens.home

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.github_browser.ui.components.ScaffoldUse
import com.example.github_browser.ui.models.GitRepo
import com.example.github_browser.ui.util.Routes

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {

    println("Kya haal hai")

    ScaffoldUse(
        topBarTitle = "Github Browser",
        onClickTopButton = { navController.navigate(Routes.AddRepo.route) },
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            val username = "gulshanpatidar"
            val repoName = "InstagramLight"

//        viewModel.getRepoDetails(username = username, repoName = repoName)

            val name by remember {
                viewModel.name
            }

            var buttonClicked by remember {
                mutableStateOf(false)
            }

            val repos = viewModel.gitRepos

            if (repos.isNotEmpty()) {
                LazyColumn(contentPadding = PaddingValues(16.dp)) {
                    items(repos.size) { index ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.width(280.dp)) {
                                Text(
                                    text = repos[index].name,
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(
                                    text = repos[index].description,
                                    maxLines = 2,
                                    softWrap = true
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = "Send this information",
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .padding(12.dp)
                                    .clickable {
                                        buttonClicked = true
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider()
                        if (buttonClicked){
                            buttonClicked = false
                            sendIntent(gitRepo = repos[index])
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {
                        Text(text = "Track your favourite repo")
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { navController.navigate(Routes.AddRepo.route) },
                            modifier = Modifier.align(CenterHorizontally)
                        ) {
                            Text(
                                text = "ADD NOW",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }


//        Text(
//            text = name,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
        }
    }

}

@Composable
fun sendIntent(gitRepo: GitRepo) {
    val context = LocalContext.current
    val activity = context.findActivity()
    val intent = activity?.intent

    val sendIntent = intent?.apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT,"Repository name - ${gitRepo.name}\n Repository description - ${gitRepo.description}")
        putExtra(Intent.EXTRA_ORIGINATING_URI, gitRepo.url)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent,"Share Repository details")
    context.startActivity(shareIntent)
}

private fun Context.findActivity(): Activity? = when(this){
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
