package com.example.tecsup.user

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsup.R

class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_usuario, parent, false)) {

    private var textName: TextView? = null
    private var textPhone: TextView? = null
    private var textEmail: TextView? = null
    private var textAddress: TextView? = null

    init {
        textName = itemView.findViewById(R.id.textName)
        textPhone = itemView.findViewById(R.id.textPhone)
        textEmail = itemView.findViewById(R.id.textEmail)
        textAddress = itemView.findViewById(R.id.textAddress)
    }

    fun bind(user: User) {
        textName?.text = user.name
        textPhone?.text = user.phone
        textEmail?.text = user.email
        textAddress?.text = user.address
    }
}
