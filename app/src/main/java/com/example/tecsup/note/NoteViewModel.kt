package com.example.tecsup.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private  val repository = NoteRepository(application)
    val notas = repository.getNotes()

    fun saveNotes(nota: Note){
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(nota)
        }
    }
}