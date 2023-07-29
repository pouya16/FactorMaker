package com.example.farshfactor.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.farshfactor.R
import com.example.farshfactor.database.Settings
import com.example.farshfactor.database.User
import com.example.farshfactor.databinding.ListItemUsersBinding

class UsersListAdapter(private val onItemClicked:(User) -> Unit):
    ListAdapter<User,UsersListAdapter.UserListViewHolder>(DiffCallback){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            ListItemUsersBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }


    class UserListViewHolder(private val binding:ListItemUsersBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(userModel: User){
                binding.txtName.text = userModel.name
                binding.txtPhone.text = userModel.phone
                binding.txtOrders.text = userModel.order_count.toString()
            }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}