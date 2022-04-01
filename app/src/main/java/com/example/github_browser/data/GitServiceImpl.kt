package com.example.github_browser.data

import com.example.github_browser.data.api.GitService
import com.example.github_browser.data.models.BranchResponseItem
import com.example.github_browser.data.models.CommitResponseItem
import com.example.github_browser.data.models.GitRepoResponse
import com.example.github_browser.data.models.IssueResponseItem
import com.example.github_browser.data.util.Resource
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

//implementation of gitService interface
class GitServiceImpl(
    private val client: HttpClient
) : GitService {

    //get the repo details with username and repoName
    override suspend fun getRepos(username: String, repoName: String): Resource<GitRepoResponse> {
        val url = "${HttpRoutes.BASE_URL}/$username/$repoName"

        //make a get request by passing url if there is any error the handle it in catch block
        val repoResponse = try {
            client.get<GitRepoResponse>(url) {
                contentType(ContentType.Application.Json)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        //since there is no error, make it a success resource and pass the data in it
        return Resource.Success(data = repoResponse)
    }

    //this methods are for bonus tasks, coming soon...
    override suspend fun getBranches(
        username: String,
        repoName: String
    ): Resource<List<BranchResponseItem>> {
        val url = "${HttpRoutes.BASE_URL}/$username/$repoName/branches"

        val branchResponse = try {
            client.get<List<BranchResponseItem>>(url) {
                contentType(ContentType.Application.Json)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        return Resource.Success(data = branchResponse)
    }

    override suspend fun getIssues(
        username: String,
        repoName: String
    ): Resource<List<IssueResponseItem>> {
        val url = "${HttpRoutes.BASE_URL}/$username/$repoName/issues?state=open"

        val issueResponse = try {
            client.get<List<IssueResponseItem>>(url) {
                contentType(ContentType.Application.Json)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        return Resource.Success(data = issueResponse)
    }

    override suspend fun getCommits(
        username: String,
        repoName: String,
        branchName: String
    ): Resource<List<CommitResponseItem>> {
        val url = "${HttpRoutes.BASE_URL}/$username/$repoName/commits?sha=$branchName"

        val commitResponse = try {
            client.get<List<CommitResponseItem>>(url) {
                contentType(ContentType.Application.Json)
            }
        } catch (e: RedirectResponseException) {
            // 3XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ClientRequestException) {
            // 4XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: ServerResponseException) {
            // 5XX responses
            println("Error: ${e.response.status.description}")
            return Resource.Error(message = e.response.status.description)
        } catch (e: Exception) {
            println("Error: ${e.message}")
            return Resource.Error(message = e.message.toString())
        }

        return Resource.Success(data = commitResponse)
    }
}