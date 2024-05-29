package com.example.todocompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todocompose.data.models.TodoTask
import com.example.todocompose.database.TodoDao

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase:RoomDatabase() {

    abstract fun todoDao(): TodoDao

}