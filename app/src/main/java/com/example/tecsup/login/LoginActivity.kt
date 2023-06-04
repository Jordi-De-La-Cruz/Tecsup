package com.example.tecsup.login

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tecsup.PrincipalActivity
import com.example.tecsup.R
import com.example.tecsup.RegistrarActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity: AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val edtCorreo = findViewById<TextInputEditText>(R.id.edtCorreo)
        val edtClave = findViewById<TextInputEditText>(R.id.edtClave)

        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        btnIngresar.setOnClickListener {

            val correo = edtCorreo.text.toString()
            val clave = edtClave.text.toString()
            viewModel.login(correo, clave)

        }

        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarActivity::class.java))
        }

        observableViewModel()

    }

    fun observableViewModel(){
        viewModel.userLoginStringError.observe(this){
            alertaMensaje(it)
        }
        viewModel.userLoginServiceResponse.observe(this){
            if (it){
                startActivity(Intent(this, PrincipalActivity::class.java))
            }else{
                alertaMensaje("Error")
            }
        }
    }

    fun alertaMensaje(mensaje: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(mensaje)
        builder.setCancelable(false)
        builder.setPositiveButton("Aceptar"){_,_ ->}
        val alertDialog = builder.create()
        alertDialog.show()
    }

}