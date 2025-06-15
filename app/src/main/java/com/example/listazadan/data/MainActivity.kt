package com.example.listaZadan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.listaZadan.data.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Nie ustawiamy jeszcze layoutu – testujemy tylko bazę
        val db = TaskDatabase.getDatabase(applicationContext)
        val dao = db.taskDao()

        // Wykonujemy operacje na bazie w coroutine (asynchronicznie)
        lifecycleScope.launch {
            // Tworzymy przykładowe zadanie
            val newTask = Task(
                title = "Testowe zadanie",
                description = "Sprawdzenie działania bazy",
                priority = Priority.HIGH,
                isDone = false
            )

            dao.insert(newTask) // Dodaj do bazy

            // Odczytaj wszystkie zadania z bazy i wypisz w logu
            dao.getAll().collect { tasks ->
                tasks.forEach {
                    println("ZADANIE: ${it.id} | ${it.title} | ${it.priority}")
                }
            }
        }
    }
}
