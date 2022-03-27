package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CommitXX(
    val author: AuthorX,
    val comment_count: Int,
    val committer: Committer,
    val message: String,
    val tree: Tree,
    val url: String,
    val verification: Verification
)