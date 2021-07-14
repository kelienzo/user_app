package com.kelly.userapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kelly.userapp.databinding.UserItemBinding
import com.kelly.userapp.models.User

class UserAdapter(var users: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindUsers(user: User){
            binding.apply {
                tvName.text = user.name
                tvEmail.text = user.email
                tvStreet.text = user.address.street
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: UserItemBinding = UserItemBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUsers(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}