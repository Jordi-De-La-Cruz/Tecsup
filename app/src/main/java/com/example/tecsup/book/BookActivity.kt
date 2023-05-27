package com.example.tecsup.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsup.R
import com.example.tecsup.note.NoteAdapter

class BookActivity : AppCompatActivity() {

    private var listLibros= listOf(
        Book(R.drawable.odisea, "Odisea - Homero", "«Mientras los maderos están sujetos por las clavijas, seguiré aquí y sufriré los males que haya de padecer, y luego que las olas deshagan la balsa me pondré a nadar, pues no se me ocurre nada más provechoso»."),
        Book(R.drawable.donquijotedelamancha,"«Don Quijote de la Mancha, de Miguel de Cervantes Saavedra", "«El amor junta los cetros con los cayados; la grandeza con la bajeza; hace posible lo imposible; iguala diferentes estados y viene a ser poderoso como la muerte»."),
        Book(R.drawable.elprincipito, "El Principito, de Antoine de Saint-Exupéry", "«He aquí mi secreto. Es muy simple: no se ve bien sino con el corazón. Lo esencial es invisible a los ojos»."),
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerBooks)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            //layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            //layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = BookAdapter(listLibros)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}