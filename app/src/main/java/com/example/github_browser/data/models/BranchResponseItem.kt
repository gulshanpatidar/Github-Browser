package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class BranchResponseItem(
    val commit: CommitX,
    val name: String,
    val `protected`: Boolean
)