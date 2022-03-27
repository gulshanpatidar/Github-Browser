package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Issue(
    val title: String = "",
    val creator: String = "",
    val avatarUrl: String = ""
)
