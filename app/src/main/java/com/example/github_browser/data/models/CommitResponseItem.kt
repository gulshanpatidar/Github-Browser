package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CommitResponseItem(
    val author: Author,
    val comments_url: String,
    val commit: CommitXX,
    val committer: CommitterX,
    val html_url: String,
    val node_id: String,
    val parents: List<Parent>,
    val sha: String,
    val url: String
)