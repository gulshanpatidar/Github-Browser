package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Tree(
    val sha: String,
    val url: String
)