package com.example.tecsup.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tecsup.R

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private val userList = mutableListOf<User>()

    fun submitList(users: List<User>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)

        fun bind(user: User) {
            val firstName = user.firstName.split(" ")[0]
            nameTextView.text = firstName
            emailTextView.text = user.email
            // Configurar la imagen del usuario usando la biblioteca de carga de imágenes Glide
            Glide.with(itemView)
                .load(user.avatar)
                .into(avatarImageView)
        }


    }
}
