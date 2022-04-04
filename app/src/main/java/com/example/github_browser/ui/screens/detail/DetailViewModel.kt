package com.example.github_browser.ui.screens.detail

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_browser.data.api.GitService
import com.example.github_browser.ui.models.GitIssue
import io.ktor.http.cio.*
import kotlinx.coroutines.launch

class DetailViewModel(private val username: String,private val repoName: String): ViewModel() {

    private val gitService = GitService.create()

    val branches = mutableStateListOf<String>()

    val issues = mutableStateListOf<GitIssue>()

    init {
        getBranches(username = username, repoName = repoName)
    }

    fun getBranches(username: String, repoName: String){
        viewModelScope.launch {
            val response = gitService.getBranches(username, repoName).data
            response?.forEach {
                val title = it.name
                branches.add(title)
            }
        }
    }

    fun getIssues(username: String,repoName: String){
        viewModelScope.launch {
            val response = gitService.getIssues(username, repoName).data
            response?.forEach {
                val title = it.title
                val name = it.assignee.login
                val imageUrl = it.assignee.avatar_url
                val gitIssue = GitIssue(title, name, imageUrl)
                issues.add(gitIssue)
            }
        }
    }
}