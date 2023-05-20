package com.example.tecsup

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DocenteActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docente)

        val listDocentes = findViewById<ListView>(R.id.listDocentes)
        val list = arrayOf("José Lopez", "Diana Vera", "Jose Mendoza", "Maria Horna")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listDocentes.adapter = adapter

        registerForContextMenu(listDocentes)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflate: MenuInflater = menuInflater
        inflate.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.itemLlamar -> {
                Toast.makeText(this, "Llamar", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemMensaje -> {
                Toast.makeText(this, "Mensaje", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}