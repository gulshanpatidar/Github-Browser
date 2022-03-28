package com.example.github_browser.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_browser.data.api.GitService
import com.example.github_browser.data.models.GitRepoResponse
import com.example.github_browser.data.util.Resource
import com.example.github_browser.ui.models.GitRepo
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    //instance of gitService to make the api request
    private val gitService = GitService.create()

    var gitRepos = mutableStateListOf<GitRepo>()


    fun addRepo(username: String, repoName: String) {
        // do this operation in background thread
        viewModelScope.launch {
            //get all the fields which are needed
            val name = gitService.getRepos(
                username = username,
                repoName = repoName
            ).data?.full_name.toString()
            val description = gitService.getRepos(
                username = username,
                repoName = repoName
            ).data?.description.toString()
            val url =
                gitService.getRepos(username = username, repoName = repoName).data?.url.toString()
            //create an instance of the git repo and add it to the list
            val repo = GitRepo(name = name, description = description, url = url)
            gitRepos.add(repo)
        }
    }
}