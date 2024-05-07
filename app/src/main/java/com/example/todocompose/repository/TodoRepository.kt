package com.example.todocompose.repository

import com.example.todocompose.TodoDao
import com.example.todocompose.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    suspend fun insertTask(todoTask: TodoTask) {
    todoDao.insertTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask){
    todoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask){
    todoDao.deleteTask(todoTask)
    }

    suspend fun deleteAllTasks() {
        todoDao.deleteAllTasks()
    }

    fun getTaskById(id: Int): Flow<TodoTask> {
        return todoDao.getTaskById(id)
    }

    val getAllTasks: Flow<List<TodoTask>> = todoDao.getALlTasks()
    val searchByLowPriority: Flow<List<TodoTask>> = todoDao.searchByLowPriority()
    val searchByHighPriority: Flow<List<TodoTask>> = todoDao.searchByHighPriority()
}
