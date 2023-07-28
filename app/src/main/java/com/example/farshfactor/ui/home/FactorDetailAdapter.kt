package com.example.farshfactor.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.farshfactor.database.FactorDetail
import com.example.farshfactor.databinding.ListFactorDetailsBinding

class FactorDetailAdapter():ListAdapter<FactorDetail,FactorDetailAdapter.FactorDetailViewHolder>(
    DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactorDetailViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FactorDetailViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class FactorDetailViewHolder(private var binding: ListFactorDetailsBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item:FactorDetail){
            binding.txtPrice.text = item.price
            binding.txtQuantity.text = item.meter.toString()
            binding.txtType.text = item.washing_extra
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<FactorDetail>() {
            override fun areItemsTheSame(oldItem: FactorDetail, newItem: FactorDetail): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: FactorDetail, newItem: FactorDetail): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}