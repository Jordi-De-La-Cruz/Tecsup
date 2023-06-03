package com.example.tecsup.note

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tecsup.database.TecsupDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(application:Application) {
    private  val noteDAO: NoteDAO ? = TecsupDataBase.getInstance(application)?.noteDao()

    suspend fun insertNoteWithCoroutines(nota:Note){
        processInsertNote(nota)
    }

    private  suspend fun  processInsertNote(nota: Note) {
        withContext(Dispatchers.Default){
            noteDAO?.insert(nota)
        }
    }

    fun getNotes(): LiveData<List<Note>>?{
        return noteDAO?.getNota()
    }



}