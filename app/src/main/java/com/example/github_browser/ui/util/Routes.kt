package com.example.github_browser.ui.util

//routes of all the app screens
sealed class Routes(val route: String){
    object Home: Routes("home_screen")
    object AddRepo: Routes("add_repo_screen")
    object Detail: Routes("detail_screen")
}