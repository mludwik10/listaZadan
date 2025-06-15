package com.example.listaZadan.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// DAO – Data Access Object
@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task) // Dodaj/aktualizuj zadanie

    @Delete
    suspend fun delete(task: Task) // Usuń zadanie

    @Query("SELECT * FROM tasks ORDER BY priority DESC")
    fun getAll(): Flow<List<Task>> // Obserwowalna lista zadań
}
