package com.example.todocompose.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todocompose.utils.Action
import com.example.todocompose.utils.Constants.TASK_ARGUMENT_KEY
import com.example.todocompose.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
   navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY)
        {
            type = NavType.IntType
        })
    ){

    }

}