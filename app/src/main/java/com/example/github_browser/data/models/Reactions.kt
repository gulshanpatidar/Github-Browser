package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Reactions(
    val confused: Int,
    val eyes: Int,
    val heart: Int,
    val hooray: Int,
    val laugh: Int,
    val rocket: Int,
    val total_count: Int,
    val url: String
)