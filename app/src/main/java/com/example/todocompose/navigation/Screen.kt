package com.example.todocompose.navigation

import androidx.navigation.NavHostController
import com.example.todocompose.utils.Action
import com.example.todocompose.utils.Constants.LIST_SCREEN

class Screen(navController:NavHostController){

    val task : (Int) -> Unit = {taskId ->
        navController.navigate("task/$taskId")
    }

    val list: (Action) -> Unit = { action: Action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) {inclusive = true}
        }

    }

}
