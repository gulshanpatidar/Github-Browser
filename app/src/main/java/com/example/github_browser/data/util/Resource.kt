package com.example.github_browser.data.util

//this class is used to return the result when doing an api request
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
){
    //if the request is successful then return the data
    class Success<T>(data: T): Resource<T>(data)
    //if the request has some kind of error then make the data nullable and add an error message with it
    class Error<T>(message: String,data: T? = null): Resource<T>(message = message,data = data)
}