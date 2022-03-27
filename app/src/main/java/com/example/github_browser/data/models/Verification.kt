package com.example.github_browser.data.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Verification(
    val reason: String,
    val verified: Boolean
)