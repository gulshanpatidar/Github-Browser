package com.example.github_browser.data.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthorX(
    val date: String,
    val email: String,
    val name: String
)