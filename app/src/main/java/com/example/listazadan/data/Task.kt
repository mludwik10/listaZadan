package com.example.listazadan.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Reprezentuje jedno zadanie jako wiersz w tabeli "tasks"
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Unikalny ID
    val title: String,         // Tytuł zadania
    val description: String,   // Opis zadania
    val priority: Priority,    // Poziom priorytetu
    val isDone: Boolean = false // Czy ukończone
)
