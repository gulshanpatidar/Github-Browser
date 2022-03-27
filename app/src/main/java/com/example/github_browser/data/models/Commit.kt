package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Commit(
    val date: String = "",
    val message: String = "",
    val userName: String = "",
    val avatarUrl: String = ""
)