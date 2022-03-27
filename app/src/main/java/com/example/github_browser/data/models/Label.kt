package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Label(
    val color: String,
    val default: Boolean,
    val description: String,
    val id: Long,
    val name: String,
    val node_id: String,
    val url: String
)