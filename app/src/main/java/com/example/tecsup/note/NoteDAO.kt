package com.example.tecsup.note

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    @Insert
    fun insert(nota: Note)
    @Update
    fun update(nota: Note)
    @Delete
    fun  delete(nota: Note)

    @Query("SELECT * FROM note_table")
    fun getNota(): LiveData<List<Note>>

}