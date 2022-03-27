package com.example.github_browser.data.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Verification(
    @Contextual
    val payload: Any,
    val reason: String,
    @Contextual
    val signature: Any,
    val verified: Boolean
)