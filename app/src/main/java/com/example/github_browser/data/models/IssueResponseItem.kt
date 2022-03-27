package com.example.github_browser.data.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class IssueResponseItem(
    @Contextual
    val active_lock_reason: Any,
    val assignee: Assignee,
    val assignees: List<Assignee>,
    val author_association: String,
    val body: String,
    @Contextual
    val closed_at: Any,
    val comments: Int,
    val comments_url: String,
    val created_at: String,
    val events_url: String,
    val html_url: String,
    val id: Int,
    val labels: List<Label>,
    val labels_url: String,
    val locked: Boolean,
    @Contextual
    val milestone: Any,
    val node_id: String,
    val number: Int,
    @Contextual
    val performed_via_github_app: Any,
    val reactions: Reactions,
    val repository_url: String,
    val state: String,
    val timeline_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: User
)