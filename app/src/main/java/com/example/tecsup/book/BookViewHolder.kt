package com.example.tecsup.book

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsup.R

class BookViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_libro , parent, false)){

    private var imgBook: ImageView? = null
    private var textTitle: TextView? = null
    private var textDescription: TextView? = null

    init {
        imgBook = itemView.findViewById(R.id.imgBook)
        textTitle = itemView.findViewById(R.id.textTitle)
        textDescription = itemView.findViewById(R.id.textDescription)
    }

    fun bind(libro: Book) {
        imgBook?.setImageResource(libro.imagen)
        textTitle?.text = libro.titulo
        textDescription?.text = libro.contenido
    }

}