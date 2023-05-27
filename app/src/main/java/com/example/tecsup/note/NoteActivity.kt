package com.example.tecsup.note

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tecsup.R

class NoteActivity: AppCompatActivity() {

    private var listNotas = listOf(
        Note("Titulo nota 1", "Contenido 1", "20-05-2023"),
        Note("Titulo nota 2", "Contenido 1 Contenido 2", "20-05-2023"),
        Note("Titulo nota 3", "Contenido 1 Contenido2 Contenido 3", "20-05-2023")
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNotes)

        recyclerView.apply {
            //layoutManager = LinearLayoutManager(context)
            //layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = NoteAdapter(listNotas)
        }

    }

}