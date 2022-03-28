package com.example.github_browser.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//composable for top app bar which has condition that if it is a home screen then show the add repo button, otherwise show the back button in the top app bar

@Composable
fun TopBar(
    title: String,
    onTopButtonClicked: () -> Unit,
) {
    if (title == "Github Browser") {
        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Button to add new repo",
                        modifier = Modifier
                            .clickable(onClick = onTopButtonClicked)
                            .padding(end = 12.dp)
                            .size(30.dp),
                        tint = Color.White
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = {
                Text(
                    text = title,
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Button to go back",
                    modifier = Modifier
                        .clickable(onClick = onTopButtonClicked)
                        .padding(horizontal = 12.dp)
                        .size(30.dp),
                    tint = Color.White
                )
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}