package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Parent(
    val html_url: String,
    val sha: String,
    val url: String
)