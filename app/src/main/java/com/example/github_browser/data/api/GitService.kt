package com.example.github_browser.data.api

import com.example.github_browser.data.GitServiceImpl
import com.example.github_browser.data.models.*
import com.example.github_browser.data.util.Resource
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface GitService {

    suspend fun getRepos(username: String, repoName: String): Resource<GitRepoResponse>

    suspend fun getBranches(username: String, repoName: String): Resource<List<BranchResponseItem>>

    suspend fun getIssues(username: String, repoName: String): Resource<List<IssueResponseItem>>

    suspend fun getCommits(username: String, repoName: String): Resource<List<CommitResponseItem>>

    companion object {
        fun create(): GitService {
            return GitServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                            ignoreUnknownKeys = true
                            coerceInputValues = true
                        })
                    }
                }
            )
        }
    }
}