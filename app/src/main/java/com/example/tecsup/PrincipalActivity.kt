package com.example.tecsup

import android.content.Intent
import android.view.View
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tecsup.book.BookActivity
import com.example.tecsup.calculator.CalculatorActivity
import com.example.tecsup.note.NoteActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class PrincipalActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationViewLeft: NavigationView
    private lateinit var navigationViewRigth: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btnCurso = findViewById<Button>(R.id.btnCurso)
        btnCurso.setOnClickListener {
            val intent = Intent(this, CursoActivity::class.java)
            intent.putExtra("mensaje_key", "Actividad para Cursos")
            startActivity(intent)
        }

        val btnEstudiante = findViewById<Button>(R.id.btnEstudiante)
        btnEstudiante.setOnClickListener {
            val intent = Intent(this, EstudianteActivity::class.java)
            intent.putExtra("mensaje_key", "Actividad para Estudiantes")
            startActivity(intent)
        }

        val btnNota = findViewById<Button>(R.id.btnNota)
        btnNota.setOnClickListener {
            val intent = Intent(this, NotaActivity::class.java)
            intent.putExtra("mensaje_key", "Actividad para Notas")
            startActivity(intent)
        }

        val btnDocente = findViewById<Button>(R.id.btnDocente)
        btnDocente.setOnClickListener {
            val intent = Intent(this, DocenteActivity::class.java)
            intent.putExtra("mensaje_key", "Actividad para Docentes")
            startActivity(intent)
        }

        val floatingPreguntas = findViewById<FloatingActionButton>(R.id.floatingPreguntas)
        floatingPreguntas.setOnClickListener {
            showPopupMenu(floatingPreguntas)
        }

        drawerLayout = findViewById(R.id.drawer_layout)

        navigationViewLeft = findViewById(R.id.nav_view_left)
        configurationNavigationDrawerLeft()

        navigationViewRigth = findViewById(R.id.nav_view_right)
        configurationNavigationDrawerRight()

        val btnRightNav = findViewById<ImageView>(R.id.imgAccount)
        val btnLeftNav = findViewById<ImageView>(R.id.imgMenu)

        btnRightNav.setOnClickListener {
            navigationViewLeft.isEnabled = true
            drawerLayout.openDrawer(GravityCompat.START)
        }

        btnLeftNav.setOnClickListener {
            navigationViewRigth.isEnabled = true
            drawerLayout.openDrawer(GravityCompat.END)
        }
    }

    private fun showPopupMenu(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.popup_menu, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.itemEnviar -> {
                Toast.makeText(this, "Enviar", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemConversar -> {
                Toast.makeText(this, "Conversar", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemPreguntas -> {
                Toast.makeText(this, "Preguntas", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
        }
    }

    private fun configurationNavigationDrawerLeft() {
        navigationViewLeft.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawer(GravityCompat.START)
            when (menuItem.itemId) {
                R.id.itemPrincipal -> {
                    Toast.makeText(this, "Principal", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemCursos -> {
                    Toast.makeText(this, "Cursos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemNotas -> {
                    startActivity(Intent(this, NoteActivity::class.java))
                    Toast.makeText(this, "Notas", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemLibros -> {
                    startActivity(Intent(this, BookActivity::class.java))
                    Toast.makeText(this, "Libros", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemCalculadora -> {
                    startActivity(Intent(this, CalculatorActivity::class.java))
                    Toast.makeText(this, "Calculadora", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun configurationNavigationDrawerRight() {
        navigationViewRigth.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawer(GravityCompat.END)
            when (menuItem.itemId) {
                R.id.itemNoticias -> {
                    Toast.makeText(this, "Noticias", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemCursos -> {
                    Toast.makeText(this, "Cursos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemProfesores -> {
                    Toast.makeText(this, "Profesores", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemEstudiantes -> {
                    Toast.makeText(this, "Estudiantes", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemNotas -> {
                    Toast.makeText(this, "Notas", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

}