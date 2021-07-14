package com.kelly.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelly.userapp.databinding.ActivityMainBinding
import com.kelly.userapp.ui.MainViewModel
import com.kelly.userapp.ui.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.userRv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.run {
            getUsers()
            usersLiveData.observe(this@MainActivity, {users ->
                userAdapter.users = users
                userAdapter.notifyDataSetChanged()
            })
        }

    }
}