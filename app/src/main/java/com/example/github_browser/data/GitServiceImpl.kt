package com.example.github_browser.data

import com.example.github_browser.data.api.GitService
import com.example.github_browser.data.models.*
import com.example.github_browser.data.util.Resource
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.request.get
import io.ktor.http.*

class GitServiceImpl(
    private val client: HttpClient
): GitService {
    override suspend fun getRepos(username: String, repoName: String): Resource<GitRepoResponse> {
        val url = "${HttpRoutes.BASE_URL}/$username/$repoName"

        val repoResponse = try {
            client.get<GitRepoResponse>(url) {
                contentType(ContentType.Application.Json)
            }
        }catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error<GitRepoResponse>(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error<GitRepoResponse>(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error<GitRepoResponse>(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        return Resource.Success(data = repoResponse)
    }

    override suspend fun getBranches(username: String, repoName: String): Resource<List<BranchResponseItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun getIssues(username: String, repoName: String): Resource<List<IssueResponseItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCommits(username: String, repoName: String): Resource<List<CommitResponseItem>> {
        TODO("Not yet implemented")
    }
}