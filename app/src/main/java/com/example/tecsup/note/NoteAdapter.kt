package com.example.tecsup.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter():
    RecyclerView.Adapter<NoteViewHolder>() {

    private var notaLista = emptyList<Note>()

    fun setNotas(notas:List<Note>){
        this.notaLista = notas
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        var inflater = LayoutInflater.from(parent.context)
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