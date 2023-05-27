package com.example.tecsup.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private var notaLista: List<Note>) :
    RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return notaLista.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val nota: Note = notaLista[position]
        holder.bind(nota)
    }

    interface ItemClickListener {
        fun onItemClick(noteItem: Note)
    }

}