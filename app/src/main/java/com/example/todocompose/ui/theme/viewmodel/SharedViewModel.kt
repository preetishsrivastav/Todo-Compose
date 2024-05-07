package com.example.todocompose.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todocompose.data.models.TodoTask
import com.example.todocompose.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val todoRepository: TodoRepository):ViewModel() {

    private val _allTasks = MutableStateFlow<List<TodoTask>>(emptyList())
    val allTasks:StateFlow<List<TodoTask>> = _allTasks
   fun getAllTasks(){
       viewModelScope.launch {
           todoRepository.getAllTasks.collect{
             _allTasks.value = it 
           }
       }
   }
}