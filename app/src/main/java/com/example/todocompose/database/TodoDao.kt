package com.example.todocompose.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todocompose.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getALlTasks(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table WHERE id = :id")
    fun getTaskById(id: Int): Flow<TodoTask>

    @Delete
    suspend fun deleteTask(todoTask: TodoTask)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(todoTask: TodoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Update
    suspend fun updateTask(todoTask: TodoTask)

    @Query("Select * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE  :searchQuery")
    fun searchTasks(searchQuery: String): Flow<TodoTask>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun searchByLowPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun searchByHighPriority(): Flow<List<TodoTask>>

}