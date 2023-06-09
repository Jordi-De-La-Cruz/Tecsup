package com.example.tecsup.userlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tecsup.R
import com.example.tecsup.userlist.UserListAdapter
import com.example.tecsup.userlist.UserListViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserListAdapter

    private val viewModel: UserListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        viewModel.userListLiveData.observe(this) { users ->
            adapter.submitList(users)
        }

        viewModel.errorLiveData.observe(this) { error ->
            Toast.makeText(this@UserListActivity, error, Toast.LENGTH_SHORT).show()
        }

        viewModel.fetchUserList()
    }
}
