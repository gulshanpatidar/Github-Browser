package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class GitOwner(
    val avatar_url: String ="",
    val url: String = ""
)