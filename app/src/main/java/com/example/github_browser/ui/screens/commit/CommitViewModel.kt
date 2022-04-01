package com.example.github_browser.ui.screens.commit

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_browser.data.api.GitService
import com.example.github_browser.ui.models.GitCommit
import kotlinx.coroutines.launch

class CommitViewModel: ViewModel() {

    private val gitService = GitService.create()

    val commits = mutableStateListOf<GitCommit>()

    fun getCommits(username: String, repoName: String,branchName: String){
        viewModelScope.launch {
            val response = gitService.getCommits(username, repoName,branchName).data

            response?.forEach {
                val date = it.commit.author.date
                val message = it.commit.message
                val name = it.commit.author.name
                val imageUrl = it.author.avatar_url

                val repoCommit = GitCommit(date, message, name, imageUrl)
                commits.add(repoCommit)
            }
        }
    }
}