package com.example.todocompose.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todocompose.R
import com.example.todocompose.components.PriorityItem
import com.example.todocompose.data.models.Priority


@Composable
fun ListAppBar() {
    DefaultListAppBar(onSearchClicked = {},
        onSortClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Tasks")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),

        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked
            )
        }


    )

}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {

    IconButton(onClick = { onSearchClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_action_description),
            tint = Color.White
        )
    }

}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {

        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = stringResource(id = R.string.sort_action),
            tint = Color.White

        )

    }

    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded = false }) {

        DropdownMenuItem(
            text = { Text(text = "") },
            onClick = {
                expanded = false
                onSortClicked(Priority.HIGH)
            },
            leadingIcon = {
                PriorityItem(priority = Priority.HIGH)
            }
        )

        DropdownMenuItem(
            text = { Text(text = "") },
            onClick = {
                expanded = false
                onSortClicked(Priority.MEDIUM)
            },
            leadingIcon = {
                PriorityItem(priority = Priority.MEDIUM)
            }

        )

        DropdownMenuItem(
            text = { Text(text = "") },
            onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            },
            leadingIcon = {
                PriorityItem(priority = Priority.LOW)
            }
        )

        DropdownMenuItem(
            text = { Text(text = "") },
            onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            },
            leadingIcon = {
                PriorityItem(priority = Priority.NONE)
            }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDefaultAppBar() {
    DefaultListAppBar(onSearchClicked = {},
        onSortClicked = {})
}