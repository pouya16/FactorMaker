package com.example.farshfactor.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.farshfactor.database.Settings
import com.example.farshfactor.databinding.ListFactorDetailsBinding
import com.example.farshfactor.databinding.ListItemSettingBinding

class SettingListAdapter(private val onItemClicked:(Settings) -> Unit):
    ListAdapter<Settings,SettingListAdapter.SettingsViewHolder>(DiffCallback){



    class SettingsViewHolder(private val binding: ListItemSettingBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(setting:Settings){
            binding.txtName.text = setting.type
            binding.txtType.text = setting.count_kind
            binding.txtPrice.text = setting.price
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        return SettingsViewHolder(
            ListItemSettingBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Settings>() {
            override fun areItemsTheSame(oldItem: Settings, newItem: Settings): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Settings, newItem: Settings): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}