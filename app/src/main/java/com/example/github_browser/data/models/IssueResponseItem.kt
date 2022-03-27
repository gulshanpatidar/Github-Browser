package com.example.github_browser.data.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class IssueResponseItem(
    val assignee: Assignee,
    val assignees: List<Assignee>,
    val author_association: String,
    val body: String,
    val comments: Int,
    val comments_url: String,
    val created_at: String,
    val events_url: String,
    val html_url: String,
    val id: Int,
    val labels: List<Label>,
    val labels_url: String,
    val locked: Boolean,
    val node_id: String,
    val number: Int,
    val reactions: Reactions,
    val repository_url: String,
    val state: String,
    val timeline_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: User
)