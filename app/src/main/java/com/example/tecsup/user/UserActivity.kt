package com.example.tecsup.user

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

class UserActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerUsers)

        val adapter = UserAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.users?.observe(this) { users ->
            users?.let {
                adapter.setUsers(users)
            }
        }

        val floatingUser = findViewById<FloatingActionButton>(R.id.floatingUsuario)
        floatingUser.setOnClickListener {
            registerAndUpdateUser()
        }
    }

    private fun registerAndUpdateUser() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_user, null)

        val titleAlertDialog = "Register User"

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(titleAlertDialog)

        val alertDialog = alertDialogBuilder.show()

        val buttonCreate = dialogView.findViewById<Button>(R.id.btnCreate)
        val editTextName = dialogView.findViewById<EditText>(R.id.edtNameUser)
        val editTextPhone = dialogView.findViewById<EditText>(R.id.edtPhoneUser)
        val editTextEmail = dialogView.findViewById<EditText>(R.id.edtEmailUser)
        val editTextAddress = dialogView.findViewById<EditText>(R.id.edtAddressUser)

        buttonCreate.setOnClickListener {
            alertDialog.dismiss()

            val name = editTextName.text.toString()
            val phone = editTextPhone.text.toString()
            val email = editTextEmail.text.toString()
            val address = editTextAddress.text.toString()

            val user = User(name, phone, email, address)
            userViewModel.saveUser(user)
        }
    }
}
