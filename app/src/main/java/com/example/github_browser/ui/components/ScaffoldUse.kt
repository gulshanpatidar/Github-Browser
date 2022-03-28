package com.example.github_browser.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.example.github_browser.ui.AppNavigation
import com.example.github_browser.ui.util.Routes

//this composable is for the scaffold which is used by the screens
@Composable
fun ScaffoldUse(
    topBarTitle: String,
    onClickTopButton: () -> Unit,
    content: @Composable () -> Unit
) {

    Scaffold(
        topBar = {
            TopBar(title = topBarTitle) {
                onClickTopButton()
            }
        }
    ) {
        content()
    }
}