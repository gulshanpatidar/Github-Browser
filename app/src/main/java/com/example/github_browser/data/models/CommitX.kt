package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CommitX(
    val sha: String,
    val url: String
)