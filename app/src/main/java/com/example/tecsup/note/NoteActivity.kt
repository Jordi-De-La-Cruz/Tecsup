package com.example.tecsup.note

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsup.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteActivity: AppCompatActivity() {

    private  lateinit var  notaViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        notaViewModel = run {
            ViewModelProvider(this)[NoteViewModel::class.java]
        }

        val reclerView = (findViewById< RecyclerView>(R.id.recyclerNotes))

        val adapter = NoteAdapter()
        reclerView.adapter = adapter
        reclerView.layoutManager = LinearLayoutManager(this)

        notaViewModel.notas?.observe(this){ notas ->
            notas?.let{
                adapter.setNotas(notas)
            }

        }
        val floatingNota = findViewById<FloatingActionButton>(R.id.floatingNota)
        floatingNota.setOnClickListener{
            registerAndUpdateNote()
        }

    }
    private fun registerAndUpdateNote() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_note, null)

        val titleAlertNote = "Registrar nota"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mDialogView.findViewById<Button>(R.id.btnCreate)
        val editTextTitleCreate  = mDialogView.findViewById<EditText>(R.id.edtTitleNote)
        val editTextDescriptionCreate  = mDialogView.findViewById<EditText>(R.id.edtDescriptionNote)

        buttonCreate.setOnClickListener {

            mAlertDialog.dismiss()

            val titleNote = editTextTitleCreate.text.toString()
            val descriptionNote = editTextDescriptionCreate.text.toString()
            val currentDateTime ="2023-12-12" //LocalDateTime.now().formatChangeNote()

            var noteVM = Note(titleNote, descriptionNote, currentDateTime)
            notaViewModel.saveNotes(noteVM)

        }
    }



}