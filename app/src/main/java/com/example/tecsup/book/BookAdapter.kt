package com.example.tecsup.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private var libroLista: List<Book>):
    RecyclerView.Adapter<BookViewHolder>() {

    override fun getItemCount(): Int {
        return libroLista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val libro: Book = libroLista[position]
        holder.bind(libro)
    }

    interface ItemClickListener {
        fun onItemClick(libroItem: Book)
    }

}