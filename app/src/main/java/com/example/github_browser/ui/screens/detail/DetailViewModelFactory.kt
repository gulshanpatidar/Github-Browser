package com.example.github_browser.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val username: String, private val repoName: String):
    ViewModelProvider.AndroidViewModelFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(username, repoName) as T
        }
        throw IllegalArgumentException("unknown viewModel class")
    }
}