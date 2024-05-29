package com.example.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todocompose.navigation.Screen
import com.example.todocompose.navigation.destination.listComposable
import com.example.todocompose.navigation.destination.taskComposable
import com.example.todocompose.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController) {

    val screen = remember(navController){
        Screen(navController = navController)
    }

   NavHost(navController = navController, startDestination = LIST_SCREEN){
      listComposable(
          screen.task
      )
       taskComposable(
           screen.list
       )
       
   }
}